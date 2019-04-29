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
		cashRegister = new CashRegister(200); //Placeholder value of balance
	}
	
	/***
	 * Starts the process of a new purchase by creating
	 * an instance of Purchase.
	 */
	public void startNewAPurchase() {
		purchase = new Purchase(cashRegister);
	}

    /***
     * Searches for PurchaseItemDTO in inventory database
     * @return scannedItem The found PurchaseItemDTO in the database
     */
	public PurchaseItemDTO scanItem() {
		PurchaseItemDTO scannedItem = ItemIdentifier.scanItem("193993"); //Temporary barcode
		purchase.addItemToPurchase(scannedItem,1); //Temporary quantity
		return scannedItem;
	}

	public PurchaseDTO applyAvailableDiscounts(String customerID) {
		return null;
	}

	public double pay(double amount) {
		return 0;
	}

}
