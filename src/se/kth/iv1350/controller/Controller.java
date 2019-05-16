package se.kth.iv1350.controller;

import se.kth.iv1350.integration.DatabaseFailureException;
import se.kth.iv1350.integration.NoMatchingIDException;
import se.kth.iv1350.logger.FileLogger;
import se.kth.iv1350.model.Purchase;
import se.kth.iv1350.model.CashRegister;
import se.kth.iv1350.integration.PurchaseItemDTO;
import se.kth.iv1350.integration.ItemDatabaseControls;
import se.kth.iv1350.model.PurchaseDTO;
import se.kth.iv1350.model.PurchaseObserverInterface;

import java.io.IOException;

/**
 * @author Filip
 * The only controller for this class.
 * All calls made to the models go through this class.
 */
public class Controller {

	private Purchase purchase;
	private CashRegister cashRegister;
	private FileLogger fileLogger;


	/***
	 * Creates a new instance and initializes cashRegister.
	 */
	public Controller()
	{
		cashRegister = new CashRegister(200); // Placeholder value of balance
		purchase = new Purchase(cashRegister);

		try {
            fileLogger = new FileLogger();
        }
		catch (IOException exc){
		    System.out.println("Can't log...");
        }
	}
	
	/***
	 * Starts the process of a new purchase by creating
	 * an instance of Purchase.
	 */
	public void startNewAPurchase() {
		purchase = new Purchase(cashRegister);
	}

	/**
	 * Adds observer to <code>Purchase</code>
	 * @param purchaseObserver Observer added to <code>Purchase</code>
	 */
	public void addObserver(PurchaseObserverInterface purchaseObserver){
		purchase.addObserver(purchaseObserver);
	}

    /***
     * Searches inventory database for item based on the id
     * and adds it to the purchase.
     * @param id Used to identify item to purchase
     * @param quantity Specifies the quantity of items to purchase
     * @return Returns matching object from database
	 * @throws OperationFailedException	If the item ID wasn't found
	 * 									in the database.
	 * @throws Exception	Not apart of the seminar.
     */
	public PurchaseItemDTO scanItem(String id, int quantity) throws OperationFailedException, Exception{
	    if (quantity < 1)
	        throw new Exception("Invalid quantity of " + quantity
            + " entered");
	    	try {
				PurchaseItemDTO scannedItem = ItemDatabaseControls.getSingleton().scanItem(id);
				scannedItem.setAmount(quantity);
				return purchase.addItemToPurchase(scannedItem);
			}
	    	catch (NoMatchingIDException exc){
				fileLogger.log(exc);
	    		throw new OperationFailedException("Item ID could not be found",exc);

			}
			catch (DatabaseFailureException exc){
				fileLogger.log(exc);
				throw new ConnectionIssueException("Database not responding");
			}
	}

	/***
	 * Searches for available discounts and applies them to the purchase.
	 * @param customerID Used to search database for available discounts
	 *                   based on the customer's id
	 * @return Returns the updated purchase.
	 */
	public PurchaseDTO applyAvailableDiscounts(String customerID) {
		return purchase.findAndApplyDiscounts(customerID);
	}

    /***
     * Used to pay for the purchase
     * @param amount The amount the customer is paying
     * @return Returns the change of the purchase
     */
	public double pay(double amount) throws Exception{
		return purchase.pay(amount);
	}

}
