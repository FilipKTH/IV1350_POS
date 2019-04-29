package se.kth.iv1350.integration;

public class PurchaseItemDTO {

	private double price;

	private double vat;

	private int amount;

	private String itemDescription;

	public PurchaseItemDTO itemDTO(double price, double vat, int amount, String itemDescription) {
		return null;
	}

	public double getPrice() {
		return price;
	}

	public double getVAT() {
		return vat;
	}

	public int getAmount() {
		return amount;
	}

	public String getItemDescription() {
		return itemDescription;
	}

}
