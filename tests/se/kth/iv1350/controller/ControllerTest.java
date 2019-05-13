package se.kth.iv1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.NoMatchingIDException;
import se.kth.iv1350.integration.PurchaseItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller instance;
    @BeforeEach
    void setUp() {
        instance = new Controller();

    }

    @AfterEach
    void tearDown() {
    }
   /* @Test
    void startNewAPurchase() {
    }*/

    @Test
    void scanningExistingItem() throws Exception{
            PurchaseItemDTO result = instance.scanItem("apple", 1);
            String expResult = "apple";
            assertEquals(expResult, result.getItemID(), "Object wasn't successfully returned");
            assertTrue(result.getAmount() == 1, "Amount wasn't successfully updated");
    }

    @Test
    void scanningMultipleItemsOfSameType() {
        try {
            PurchaseItemDTO result = instance.scanItem("apple", 3);
            String expResult = "apple";
            int expResult2 = 3;
            assertEquals(expResult, result.getItemID(), "Object wasn't successfully returned");
            assertEquals(expResult2, result.getAmount(), "Amount wasn't successfully updated");
        }
        catch (Exception e){
            fail("No invalid parameters were entered");
        }
    }

    @Test
    void scanningMultipleItemsOfSameTypeSeparately() {
        try {
            instance.scanItem("apple", 3);
            PurchaseItemDTO result = instance.scanItem("apple", 2);
            String expResult = "apple";
            int expResult2 = 5;
            assertEquals(expResult,result.getItemID(), "Object wasn't successfully returned");
            assertEquals(expResult2,result.getAmount(), "Amount wasn't successfully updated");
        }
        catch (Exception e){
            fail("No invalid parameters were entered");
        }
    }

    @Test
    void scanningNonExistingItemID() throws Exception{
        try{
            PurchaseItemDTO result = instance.scanItem("wild cowboy", 2);
            fail("Due to the item being null an exception should have ben thrown");
        }
        catch (OperationFailedException exc){
            assertTrue(exc.getMessage().contains("ID"),"Wrong exception tossed," +
                    " tossed exception: " + exc.getMessage());
        }
    }

    @Test
    void scanningItemWithInvalidQuantity(){
        try{
            PurchaseItemDTO result = instance.scanItem("apple", -2);
            fail("Due to the quantity being invalid an exception should have ben thrown");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("quantity"),"Wrong exception tossed");
        }
    }

    /*@Test
    void pay() {
    }*/
}