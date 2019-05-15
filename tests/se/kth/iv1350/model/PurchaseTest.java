package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.ItemDatabaseControls;
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
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
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
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
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
            PurchaseItemDTO item = ItemDatabaseControls.getSingleton().scanItem("apple");
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
    @Test
    void payTooMuch() {
        try {
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));

            double result = purchase.pay(30);
            double expResult = 10;

            assertEquals(expResult,result,"Wrong change returned");
        }
        catch (Exception e){
            fail("Exception given: " + e.getMessage());
        }
    }

    @Test
    void payEven() {
        try {
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));

            double result = purchase.pay(20);
            double expResult = 0;

            assertEquals(expResult,result,"Wrong change returned");
        }
        catch (Exception e){
            fail("Exception given: " + e.getMessage());
        }
    }

    @Test
    void payTooLittle() {
        try {
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));
            purchase.addItemToPurchase(ItemDatabaseControls.getSingleton().scanItem("apple"));

            double result = purchase.pay(10);
            fail("Exception should have been tossed");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("less"), "Wrong  exception: " + e.getMessage());
        }
    }
}