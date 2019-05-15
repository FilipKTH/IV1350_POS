package se.kth.iv1350.integration;

import se.kth.iv1350.model.PurchaseDTO;

class MultipleOfSameItemDiscount implements Discount {
    @Override
    public DiscountDTO generateDiscount(String customerID, PurchaseDTO purchaseDTO) {
        return new DiscountDTO(getDiscountInMoney(purchaseDTO));
    }

    private double getDiscountInMoney(PurchaseDTO purchaseDTO){
        double discountInMoney = purchaseDTO.getRunningTotal();

        for (PurchaseItemDTO purchaseItemDTO : purchaseDTO.getItemDTOs()){
            if(purchaseItemDTO.getAmount() > 2){
                discountInMoney -= purchaseItemDTO.getPrice() *
                        (purchaseItemDTO.getAmount() - 1);
            }
        }
        return discountInMoney;
    }
}
