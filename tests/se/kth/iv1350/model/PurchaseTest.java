package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.ItemIdentifier;

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

    /*
    Things to test:
    1: adding a existing (database) item
    2: adding null item
    3: adding item with bigger quantity than 1
    4: adding item with quantity less than 1
    5: adding already existing (purchase list) item
 */
    @Test
    void addingExistingItem() {
        try {
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"), 1);
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
            purchase.addItemToPurchase(null,10);
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
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"), 1);
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"), 1);
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
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"), 5);
            assertTrue(purchase.getItemsToPurchase()[0].getAmount() == 5,
                    "Amount wasn't successfully added");
        }
        catch (Exception e){
            fail("Null exception should not be possible when" +
                    " adding instantiated PurchaseItemDTO");
        }
    }

    @Test
    void addingItemWithInvalidQuantity(){
        try{
            purchase.addItemToPurchase(ItemIdentifier.scanItem("apple"), -5);
            fail("Exception should have been tossed, due to the attempt of" +
                    "adding an invalid quantity...");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("entered"), "Wrong exception was triggered...");
        }
    }
    /*@Test
    void pay() {
    }*/
}