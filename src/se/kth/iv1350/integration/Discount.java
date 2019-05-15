package se.kth.iv1350.integration;

import se.kth.iv1350.model.PurchaseDTO;

import java.util.List;

public interface Discount {
    /**
     * Generates a discount based on given
     * conditions.
     * @param customerID    Used to base discount on the
     *                      customer.
     *                      (Note: in this system there is
     *                      no database, that's why customerID
     *                      won't be used. But it's intended to
     *                      be used further on.)
     * @param purchaseDTO   Used to base discount on bought items
     * @return  Returns <code>Discount</code> as DTO,
     *          <code>DiscountDTO</code>
     *          (Note: The class <code>Discount</code> is meant to
     *          be more complex in the future, that's why a class
     *          is used even when it only contains 1 variable.)
     */
    DiscountDTO generateDiscount(String customerID, PurchaseDTO purchaseDTO);
}
