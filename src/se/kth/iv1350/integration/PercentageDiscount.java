package se.kth.iv1350.integration;

import se.kth.iv1350.model.PurchaseDTO;

class PercentageDiscount implements Discount {
    @Override
    public DiscountDTO generateDiscount(String customerID, PurchaseDTO purchaseDTO) {
        double discountInMoney = purchaseDTO.getRunningTotal() *
                (1-getDiscountPercentage(purchaseDTO));
        return new DiscountDTO(discountInMoney);
    }

    private double getDiscountPercentage(PurchaseDTO purchaseDTO){
        double price = purchaseDTO.getRunningTotal();
        double discountPercentage = 1;

        if (price > 500){
            discountPercentage = 0.9;
        }
        else if(price > 1000){
            discountPercentage = 0.8;
        }
        else if(price > 2000){
            discountPercentage = 0.7;
        }
        else if(price > 3000){
            discountPercentage = 0.6;
        }
        else if(price > 5000){
            discountPercentage = 0.5;
        }
        return discountPercentage;
    }
}
