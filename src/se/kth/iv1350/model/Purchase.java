package se.kth.iv1350.model;

import se.kth.iv1350.integration.PurchaseItemDTO;
import se.kth.iv1350.integration.DiscountDTO;

public class Purchase {

	private double runningTotal;
	private double totalVAT;

	public Purchase(CashRegister cashRegister) {

	}

	public void addItemToPurchase(PurchaseItemDTO itemDTO, int quantity) {

	}

	public PurchaseItemDTO[] getItemsToPurchase() {
		return null;
	}

	public double pay(double amount) {
		return 0;
	}

	public PurchaseDTO getPurchaseDTO() {
		return null;
	}

	public PurchaseDTO findDiscounts(String customerID) {
		return null;
	}

	private void applyDiscounts(DiscountDTO[] discounts) {

	}

	private void printReceipt(PurchaseDTO purchaseDTO) {

	}

	private void updateEAS(PurchaseDTO purchaseDTO) {

	}

	private void updateInventory(PurchaseItemDTO[] itemDTOs) {

	}

}
