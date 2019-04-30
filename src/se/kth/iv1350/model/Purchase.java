package se.kth.iv1350.model;

import se.kth.iv1350.integration.*;

import se.kth.iv1350.model.Recipt;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private List<PurchaseItemDTO> listOfItemsToPurchase = new ArrayList<>();
	private CashRegister cashRegister;

	private double runningTotal;
	private double totalVAT;

	public Purchase(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
        this.runningTotal = 0;
        this.totalVAT = 0;
	}

	/***
	 * Adds items to the list of items to purchase.
	 * @param purchaseItemDTO Item to add to the list of items to purchase.
	 * @param quantity The amount of purchaseItemDTO to purchase.
	 */
	public void addItemToPurchase(PurchaseItemDTO purchaseItemDTO, int quantity) {
		PurchaseItemDTO alreadyExistingItem =
				findAndReturnPurchaseItemDTOFromPurchaseList(purchaseItemDTO.getItemID());

		if(alreadyExistingItem != null)
			alreadyExistingItem.setAmount(alreadyExistingItem.getAmount() + quantity);

		purchaseItemDTO.setAmount(quantity);
		listOfItemsToPurchase.add(purchaseItemDTO);
	}

	public PurchaseItemDTO[] getItemsToPurchase() {
		return null;
	}

    /***
     * Used to pay for the purchase
     * @param amount The amount the customer is paying
     * @return Returns the change of the purchase
     */
	public double pay(double amount) {
	    cashRegister.addMoney(amount);
		createAndPrintReceipt();
		updateEAS();
		updateInventory();
		return cashRegister.getChange(amount, runningTotal);
	}

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

	PurchaseItemDTO findAndReturnPurchaseItemDTOFromPurchaseList(String itemID){
		for (int i = 0; i < listOfItemsToPurchase.size(); i++)
			if (listOfItemsToPurchase.get(i).getItemID().equals(itemID))
				return listOfItemsToPurchase.get(i);
		return null;
	}
}
