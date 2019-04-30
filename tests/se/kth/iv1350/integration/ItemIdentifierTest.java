package se.kth.iv1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemIdentifierTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void scanItem() {
        /*
            Things to test:
            1: itemID that exists in database
            2: itemID that doesn't exists in database
            3: String = null
         */
        //Test 1
        String result1 = ItemIdentifier.scanItem("apple").getItemID();
        String expResult1 = "apple";

        //Test 2
        PurchaseItemDTO result2 = ItemIdentifier.scanItem("cowboy");

        //Test 3
        PurchaseItemDTO result3 = ItemIdentifier.scanItem(null);

        //Result of test 1
        assertTrue(result1.equals(expResult1),
                "scanItem() wasn't able to fetch the correct item.");

        //Result of test 2
        assertNull(result2, "scanItem() wasn't able to handle none existing ID");

        //Result of test 3
        assertNull(result3, "scanItem() wasn't able to handle null parameter");
    }
}