package se.kth.iv1350.integration;
import se.kth.iv1350.model.PurchaseDTO;

/**
 * Used to generate discounts based on the customer
 * and said customers list of items to purchase
 * @author Filip
 */
public class DiscountFactory {
	private static final DiscountFactory singleton = new DiscountFactory();

	/**
	 * @return Returns the only instance of
	 * <code>DiscountFactory</code>
	 */
	public static DiscountFactory getSingleton(){
		return singleton;
	}
	/***
	 * Gets available discounts based on the customer
	 * and what has been purchased.
	 * @param customerID Used to identify the customer
	 * @param purchaseDTO Used to identify what the customer
	 *                    is purchasing.
	 * @return Returns array containing legible discounts.
	 */
	public DiscountDTO getDiscount(String customerID, PurchaseDTO purchaseDTO)
	{
		//If there were more discounts compareDiscount could be a list.
		//biggestDiscount would be the first index of the list
		//and the if-statement would be inside a for-loop.
		Discount biggestDiscount = new PercentageDiscount();
		Discount compareDiscount = new MultipleOfSameItemDiscount();

		if(biggestDiscount.generateDiscount(customerID, purchaseDTO).getDiscountInMoney()
		< compareDiscount.generateDiscount(customerID, purchaseDTO).getDiscountInMoney())
			biggestDiscount = compareDiscount;

		return biggestDiscount.generateDiscount(customerID, purchaseDTO);
	}

}
