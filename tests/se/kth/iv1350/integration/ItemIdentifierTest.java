package se.kth.iv1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemIdentifierTest {
        /*
            Things to test:
            1: itemID that exists in database
            2: itemID that doesn't exists in database
            3: String = null
        */

    @Test
    void scanExistingItem() {
        //Test 1
        String result1 = ItemIdentifier.scanItem("apple").getItemID();
        String expResult1 = "apple";

        //Result of test 1
        assertEquals(expResult1, result1,
                "scanItem() wasn't able to fetch the correct item.");
    }

    @Test
    void scanNoneExistingITem(){
        //Test 2
        PurchaseItemDTO result2 = ItemIdentifier.scanItem("cowboy");
        //Result of test 2
        assertNull(result2, "scanItem() wasn't able to handle none existing ID");
    }

    @Test
    void scanNullID(){
        //Test 3
        PurchaseItemDTO result3 = ItemIdentifier.scanItem(null);
        //Result of test 3
        assertNull(result3, "scanItem() wasn't able to handle null parameter");
    }
}