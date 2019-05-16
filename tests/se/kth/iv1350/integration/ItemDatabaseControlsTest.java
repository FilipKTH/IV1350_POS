package se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDatabaseControlsTest {
        /*
            Things to test:
            1: itemID that exists in database
            2: itemID that doesn't exists in database
            3: String = null
        */

    @Test
    void scanExistingItem() throws NoMatchingIDException{
        //Test 1
        String result1 = ItemDatabaseControls.getSingleton().scanItem("apple").getItemID();
        String expResult1 = "apple";

        //Result of test 1
        assertEquals(expResult1, result1,
                "scanItem() wasn't able to fetch the correct item.");
    }

    @Test
    void scanNullID() throws NoMatchingIDException{
        //Test 3
        PurchaseItemDTO result3 = ItemDatabaseControls.getSingleton().scanItem(null);
        //Result of test 3
        assertNull(result3, "scanItem() wasn't able to handle null parameter");
    }

    @Test
    void testNoMatchingIDException(){
        try {
            PurchaseItemDTO result1 = ItemDatabaseControls.getSingleton().scanItem("dead pig");
            fail("NoMatchingIDException should have been thrown");
        }
        catch (NoMatchingIDException exc){
            assertTrue(exc.getMessage().contains("dead pig"), "Message not displaying correct.");
        }
    }

    @Test
    void TestDatabaseFailureException() throws NoMatchingIDException{
        try{
            PurchaseItemDTO result1 = ItemDatabaseControls.getSingleton().scanItem("fail");
            fail("DatabaseFailureException should have been thrown");
        }
        catch (DatabaseFailureException exc){
            assertTrue(exc.getMessage().contains("establish"));
        }
    }
}