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
            instance.payAndReturnChange(5,5);
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
            instance.payAndReturnChange(-5, 5);
            fail("Sum was invalid, exception should have been thrown");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("less"), "Wrong exception thrown, exception: " +
                    e.getMessage());
        }
    }

    @Test
    void returnCorrectChange() {
        try {
            double result1 = instance.getChange(100, 90);
            double expResult1 = 10;

            double result2 = instance.getBalance();
            double expResult2 = 190;

            assertEquals(expResult1,result1,"The wrong change was returned");
            assertEquals(expResult2,result2,"Balance wasn't updated based on the change");
        }
        catch (Exception e){
            fail("Nothing invalid should have been entered");
        }
    }

    @Test
    void notEnoughMoneyToPay(){
        try {
            double result1 = instance.getChange(10, 100);
            fail("Exception should have been thrown, not enough money to pay");
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("less"),"Wrong exception, exception: "
                    + e.getMessage());
            double result = instance.getBalance();
            double expResult = 200;
            assertEquals(expResult,result,"Amount was added to balance," +
                    " even when not the entire purchase was paid for.");
        }
    }

    @Test
    void enoughChangeWhenAmountPaidIsCountedToBalance(){
        try {
            double result1 = instance.payAndReturnChange(401,200);
            double expResult1 = 201;

            double result2 = instance.getBalance();
            double expResult2 = (200 + 401) - 201;

            assertEquals(expResult1,result1,"Wasn't able to return correct change");
            assertEquals(expResult2,result2,"Balance wasn't changed correctly");
        }
        catch (Exception e){
            fail("No exception should have been tossed, message: " + e.getMessage());
        }

    }

}