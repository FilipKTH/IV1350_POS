package se.kth.iv1350.integration;
import java.util.List;

/**
 * Used to generate discounts based on the customer
 * and said customers list of items to purchase
 * @author Filip
 */
public class DiscountGenerator {

	/***
	 * Gets available discounts based on the customer
	 * and what has been purchased.
	 * @param customerID Used to identify the customer
	 * @param purchaseDTO Used to identify what the customer
	 *                    is purchasing.
	 * @return Returns array containing legible discounts.
	 */
	public static DiscountDTO[] getDiscounts(String customerID, List<PurchaseItemDTO> purchaseDTO)
	{
		return null;
	}

}
