package se.kth.iv1350.model;

import se.kth.iv1350.integration.PurchaseItemDTO;
import se.kth.iv1350.integration.DiscountDTO;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private List<PurchaseItemDTO> listOfItemsToPurchase = new ArrayList<>();

	private double runningTotal;
	private double totalVAT;

	public Purchase(CashRegister cashRegister) {

	}

	/***
	 * Adds items to the list of items to purchase.
	 * @param itemDTO Item to add to the list of items to purchase.
	 * @param quantity The amount of itemDTO to purchase.
	 */
	public void addItemToPurchase(PurchaseItemDTO itemDTO, int quantity) {
		for (int i = 0; i < quantity; i++){
			listOfItemsToPurchase.add(itemDTO);
		}
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
