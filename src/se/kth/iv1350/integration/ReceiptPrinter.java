package se.kth.iv1350.integration;

import se.kth.iv1350.model.Recipt;

/**
 * Controls all actions between connected printer and
 * the program.
 */
public class ReceiptPrinter {
	private static final ReceiptPrinter singleton = new ReceiptPrinter();

	/**
	 * @return Returns the only instance of
	 * <code>ReceiptPrinter</code>
	 */
	public static ReceiptPrinter getSingleton(){
		return singleton;
	}
	/***
	 * Prints out receipt to the connected printer
	 * @param receipt The receipt to print out
	 */
	public void printReceipt(Recipt receipt) {

	}

}
