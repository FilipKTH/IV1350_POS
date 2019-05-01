package se.kth.iv1350.model;

import se.kth.iv1350.integration.*;

import se.kth.iv1350.model.Recipt;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls the event of a purchase. Meaning, tracking
 * items to purchase, paying for items and updating external
 * systems connected to the purchase.
 * @author Filip
 */
public class Purchase {
	private List<PurchaseItemDTO> listOfItemsToPurchase = new ArrayList<>();
	private CashRegister cashRegister;

	private double runningTotal;
	private double totalVAT;

	/***
	 * Creates instance of Purchase
	 * @param cashRegister Keeps track of money in a Purchase
	 *                     and handles payments.
	 */
	public Purchase(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
        this.runningTotal = 0;
        this.totalVAT = 0;
	}

	/***
	 * Adds items to the list of items to purchase.
	 * @param purchaseItemDTO Item to add to the list of items to purchase.
	 */
	public PurchaseItemDTO addItemToPurchase(PurchaseItemDTO purchaseItemDTO) throws Exception{
		if (purchaseItemDTO == null)
			throw new Exception("No item to add. purchaseItemDTO is null");

		addItemToRunningTotal(purchaseItemDTO);

		PurchaseItemDTO alreadyExistingItem =
				findAndReturnPurchaseItemDTOFromPurchaseList(purchaseItemDTO.getItemID());

		if(alreadyExistingItem != null) {
            alreadyExistingItem.setAmount(alreadyExistingItem.getAmount() + purchaseItemDTO.getAmount());
            return alreadyExistingItem;
        }
		else {
			listOfItemsToPurchase.add(purchaseItemDTO);
			return purchaseItemDTO;
		}
	}

	/***
	 * Converts the List of items to purchase to an array
	 * @return Array containing items to purchase
	 */
	public PurchaseItemDTO[] getItemsToPurchase() {
		PurchaseItemDTO[] arrayOfItemsToPurchase = new PurchaseItemDTO[listOfItemsToPurchase.size()];
		return arrayOfItemsToPurchase = listOfItemsToPurchase.toArray(arrayOfItemsToPurchase);
	}

    /***
     * Used to pay for the purchase
     * @param amount The amount the customer is paying
     * @return Returns the change of the purchase
     */
	public double pay(double amount) throws Exception{
		double change = cashRegister.payAndReturnChange(amount, runningTotal);

		createAndPrintReceipt();
		updateEAS();
		updateInventory();
		return change;
	}

	/***
	 * Converts this object to a PurchaseDTO
	 * @return Returns this object
	 */
	public PurchaseDTO getPurchaseDTO() {
		return null;
	}

    /***
     * Uses discount database to find available discounts and
     * applies them to the purchase.
     * @param customerID Discounts are based on the customer
     *                   customerID i used to identify.
     * @return Returns updated purchase
     */
	public PurchaseDTO findDiscounts(String customerID) {
	    DiscountDTO[] availableDiscounts = DiscountGenerator.getDiscounts(customerID,
                listOfItemsToPurchase);
	    applyDiscounts(availableDiscounts);
		return getPurchaseDTO();
	}

	private void applyDiscounts(DiscountDTO[] discounts) {
		for (int i = 0; i < discounts.length; i++)
			runningTotal -= discounts[i].getDiscountInMoney();
	}

	private void createAndPrintReceipt() {
		Recipt recipt = new Recipt(getPurchaseDTO());
		ReceiptPrinter.printReceipt(recipt);

	}

	private void updateEAS() {
		EAScontrols.logPurchase(getPurchaseDTO());
	}

	private void updateInventory() {
		InventoryControls.updateInventory(listOfItemsToPurchase);
	}

	private PurchaseItemDTO findAndReturnPurchaseItemDTOFromPurchaseList(String itemID){
		for (int i = 0; i < listOfItemsToPurchase.size(); i++)
			if (listOfItemsToPurchase.get(i).getItemID().equals(itemID))
				return listOfItemsToPurchase.get(i);
		return null;
	}

	private void addItemToRunningTotal(PurchaseItemDTO purchaseItemDTO){
		runningTotal += purchaseItemDTO.getPrice() * purchaseItemDTO.getAmount();
	}
}
