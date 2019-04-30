package se.kth.iv1350.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.controller.Controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instance;
    ByteArrayOutputStream printout;
    PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        Controller cntrl = new Controller();
        instance = new View(cntrl);

        printout = new ByteArrayOutputStream();

        PrintStream inMemSysOut = new PrintStream(printout);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSysOut);
        printout = null;
    }

    @Test
    public void testRun(){
        instance.run();
        String result = printout.toString();
        String expResult = "Init working...";
        assertTrue(result.contains(expResult), "Wrong printout after calling startNewPurchase()");
    }
}