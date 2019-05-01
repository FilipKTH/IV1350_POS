package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    CashRegister instance;

    @BeforeEach
    void setUp() {
        instance = new CashRegister(200);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addingOrdinarySum() {
        try {
            instance.addMoney(5);
            double result = instance.getBalance();
            double expResult = 205;
            assertEquals(expResult, result, "Wasn't able to add money");
        }
        catch (Exception e){
            fail("Sum wasn't invalid, exception should not have been tossed.");
        }
    }

    @Test
    void addingInvalidSum(){
        try {
            instance.addMoney(-5);
            fail("Sum was invalid, exception should have been thrown");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("invalid"), "Wrong exception thrown, exception: " +
                    e.getMessage());
        }
    }

    @Test
    void returnCorrectChange() {
        try {
            double result1 = instance.getChange(100, 90);
        }
        catch (Exception e){

        }
    }

}