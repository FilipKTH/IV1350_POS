package se.kth.iv1350.integration;

public class PurchaseItemDTO {

	private double price;
	private double vat;

	private int amount;

	private String itemDescription;
	private String itemID;

	public PurchaseItemDTO(double price, double vat, int amount, String itemID, String itemDescription) {
		this.price = price;
		this.vat = vat;
		this.amount = amount;
		this.itemID = itemID;
		this.itemDescription = itemDescription;
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
	public String getItemID(){return this.itemID;}

}
