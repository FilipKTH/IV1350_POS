package se.kth.iv1350.integration;

import se.kth.iv1350.model.PurchaseDTO;

/**
 * Used for communication with the external accounting
 * system
 * @author Filip
 */
public class EAScontrols {
	private static final EAScontrols singleton = new EAScontrols();

	/**
	 * @return Returns the only instance of
	 * <code>EASControls</code>
	 */
	public static EAScontrols getSingleton(){
		return singleton;
	}
	/***
	 * Updates the external accounting system
	 * with info regarding the current purchase
	 * @param purchaseDTO Information of the purchase to log
	 */
	public void logPurchase(PurchaseDTO purchaseDTO) {

	}

}
