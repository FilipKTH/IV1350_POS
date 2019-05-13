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
        String result1 = ItemDatabaseControls.scanItem("apple").getItemID();
        String expResult1 = "apple";

        //Result of test 1
        assertEquals(expResult1, result1,
                "scanItem() wasn't able to fetch the correct item.");
    }

    @Test
    void scanNoneExistingITem() throws NoMatchingIDException{
        //Test 2
        PurchaseItemDTO result2 = ItemDatabaseControls.scanItem("cowboy");
        //Result of test 2
        assertNull(result2, "scanItem() wasn't able to handle none existing ID");
    }

    @Test
    void scanNullID() throws NoMatchingIDException{
        //Test 3
        PurchaseItemDTO result3 = ItemDatabaseControls.scanItem(null);
        //Result of test 3
        assertNull(result3, "scanItem() wasn't able to handle null parameter");
    }
}