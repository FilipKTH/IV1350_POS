package se.kth.iv1350.model;

import se.kth.iv1350.integration.PurchaseItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains only data of a Purchase
 * @author Filip
 */
public class PurchaseDTO {

	private double runningTotal;

	private double totalVAT;

	private List<PurchaseItemDTO> itemDTOs;

	PurchaseDTO(double runningTotal, double totalVat, List<PurchaseItemDTO> itemDTOs) {
		this.runningTotal = runningTotal;
		this.totalVAT = totalVat;
		this.itemDTOs = itemDTOs;
	}

	/***
	 *
	 * @return Returns running total of the purchase
	 */
	public double getRunningTotal() {
		return this.runningTotal;
	}

	/***
	 *
	 * @return Returns the total VAT of the purchase
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}

	/***
	 *
	 * @return Returns information of all items to purchase
	 */
	public List<PurchaseItemDTO> getItemDTOs() {
		return itemDTOs;
	}

}
