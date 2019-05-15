package se.kth.iv1350.integration;

/**
 * Contains only data about a discount.
 * @author Filip
 */
public class DiscountDTO {

	private double discountInMoney;

	DiscountDTO(double discountInMoney){
		this.discountInMoney = discountInMoney;
	}
	/***
	 *
	 * @return Returns the amount of money to be discounted.
	 */
	public double getDiscountInMoney() {
		return this.discountInMoney;
	}

}
