package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.ItemIdentifier;
import se.kth.iv1350.integration.PurchaseItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    private Purchase purchase;

    @BeforeEach
    void setUp() {
        CashRegister cashRegister = new CashRegister(200);
        purchase = new Purchase(cashRegister);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addingExistingItem() {
        try {
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"));
            assertTrue(purchase.getItemsToPurchase()[0].getItemID().equals("apple"),
                    "Wasn't able to correctly add item");
        }
        catch (Exception e){
            fail("Null exception should not be possible when" +
                    " adding instantiated PurchaseItemDTO");
        }
    }

    @Test
    void addingNullItem(){
        try{
            purchase.addItemToPurchase(null);
            fail("Exception should have been tossed, due to the attempt of" +
                    "adding a null-pointer...");
        }
        catch (Exception e){
            assertTrue(e != null,"addItemToPurchase didn't throw an exception");
            assertTrue(e.getMessage().contains("null"), "Wrong exception was triggered.");
        }
    }

    @Test
    void addingSameItem(){
        try {
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"));
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"));
            assertTrue(purchase.getItemsToPurchase()[0].getAmount() == 2,
                    "Amount wasn't updated as intended");
            assertTrue(purchase.getItemsToPurchase().length == 1,
                    "An extra item of the same ID was added");

        }
        catch (Exception e){
            fail("Null exception should not be possible when" +
                    " adding instantiated PurchaseItemDTO");
        }
    }

    @Test
    void addingItemWithBiggerQuantity(){
        try {
            PurchaseItemDTO item = ItemIdentifier.scanItem("apple");
            item.setAmount(5);
            purchase.addItemToPurchase(item);
            assertTrue(purchase.getItemsToPurchase()[0].getAmount() == 5,
                    "Amount wasn't successfully added");
        }
        catch (Exception e){
            fail("Null exception should not be possible when" +
                    " adding instantiated PurchaseItemDTO");
        }
    }
    /*@Test
    void pay() {
    }*/
}