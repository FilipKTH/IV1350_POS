package se.kth.iv1350.model;

import se.kth.iv1350.integration.DiscountGenerator;
import se.kth.iv1350.integration.PurchaseItemDTO;
import se.kth.iv1350.integration.DiscountDTO;

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

    /***
     * Used to pay for the purchase
     * @param amount The amount the customer is paying
     * @return Returns the change of the purchase
     */
	public double pay(double amount) {
	    cashRegister.addMoney(amount);
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

	private void printReceipt(PurchaseDTO purchaseDTO) {

	}

	private void updateEAS(PurchaseDTO purchaseDTO) {

	}

	private void updateInventory(PurchaseItemDTO[] itemDTOs) {

	}

}
