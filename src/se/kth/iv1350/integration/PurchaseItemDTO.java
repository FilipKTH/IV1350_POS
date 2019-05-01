package se.kth.iv1350.integration;

/**
 * Contains only data about a purchase.
 * @author Filip
 */
public class PurchaseItemDTO {

	private double price;
	private double vat;

	private int amount;

	private String itemDescription;
	private String itemID;

	/***
	 * Creates instance of PurchaseItemDTO
	 * @param price Sets price of item
	 * @param vat Sets VAT of item
	 * @param amount Sets quantity to purchase of item
	 * @param itemID Sets itemID of items
	 * @param itemDescription Sets item description of item
	 */
	PurchaseItemDTO(double price, double vat, int amount, String itemID, String itemDescription) {
		this.price = price;
		this.vat = vat;
		this.amount = amount;
		this.itemID = itemID;
		this.itemDescription = itemDescription;
	}

	/**
	 * Sets a new amount
	 * @param amount Sets quantity to purchase of item
	 * @throws Exception If invalid amount is given
	 */
	public void setAmount(int amount) throws Exception{
	    if (amount < 1)
	        throw new Exception("Not valid amount. Given amount: " + amount);
		this.amount = amount;
	}

	/***
	 *
	 * @return Returns the price
	 */
	public double getPrice() {
		return price;
	}

	/***
	 *
	 * @return Returns the VAT
	 */
	public double getVAT() {
		return vat;
	}

	/***
	 *
	 * @return Returns the amount
	 */
	public int getAmount() {
		return amount;
	}

	/***
	 *
	 * @return Returns the item description
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/***
	 *
	 * @return Returns the itemID
	 */
	public String getItemID(){return this.itemID;}

}
