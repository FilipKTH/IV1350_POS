package se.kth.iv1350.controller;

import se.kth.iv1350.model.Purchase;
import se.kth.iv1350.model.CashRegister;
import se.kth.iv1350.integration.PurchaseItemDTO;
import se.kth.iv1350.integration.ItemIdentifier;
import se.kth.iv1350.model.PurchaseDTO;

/**
 * @author Filip
 * The only controller for this class.
 * All calls made to the models go through this class.
 */
public class Controller {

	private Purchase purchase;
	private CashRegister cashRegister;


	/***
	 * Creates a new instance and initializes cashRegister.
	 */
	public Controller()
	{
		cashRegister = new CashRegister(200); // Placeholder value of balance
		purchase = new Purchase(cashRegister);
	}
	
	/***
	 * Starts the process of a new purchase by creating
	 * an instance of Purchase.
	 */
	public void startNewAPurchase() {
		purchase = new Purchase(cashRegister);
	}

    /***
     * Searches inventory database for item based on the id
     * and adds it to the purchase.
     * @param id Used to identify item to purchase
     * @param quantity Specifies the quantity of items to purchase
     * @return Returns matching object from database
     */
	public PurchaseItemDTO scanItem(String id, int quantity) throws Exception{
	    if (quantity < 1)
	        throw new Exception("Invalid quantity of " + quantity
            + " entered");
			PurchaseItemDTO scannedItem = ItemIdentifier.scanItem(id);
			if (scannedItem == null)
			    throw new Exception("Item with the ID: " + id +
                        " does not exist.");

			scannedItem.setAmount(quantity);
			return purchase.addItemToPurchase(scannedItem);
	}

	/***
	 * Searches for available discounts and applies them to the purchase.
	 * @param customerID Used to search database for available discounts
	 *                   based on the customer's id
	 * @return Returns the updated purchase.
	 */
	public PurchaseDTO applyAvailableDiscounts(String customerID) {
		return purchase.findDiscounts(customerID);
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
