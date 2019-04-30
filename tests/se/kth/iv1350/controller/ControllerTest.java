package se.kth.iv1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    @Test
    void startNewAPurchase() {
    }

    @Test
    void scanningExistingItem() {
        try {
            PurchaseItemDTO result = instance.scanItem("apple", 1);
            assertTrue(result.getItemID().equals("apple"), "Object wasn't successfully returned");
            assertTrue(result.getAmount() == 1, "Amount wasn't successfully updated");
        }
        catch (Exception e){
            fail("No invalid parameters were entered");
        }
    }

    @Test
    void scanningExistingItem() {
        try {
            PurchaseItemDTO result = instance.scanItem("apple", 1);
            assertTrue(result.getItemID().equals("apple"), "Object wasn't successfully returned");
            assertTrue(result.getAmount() == 1, "Amount wasn't successfully updated");
        }
        catch (Exception e){
            fail("No invalid parameters were entered");
        }
    }

    /*@Test
    void pay() {
    }*/
}