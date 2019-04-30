package se.kth.iv1350.model;

import se.kth.iv1350.integration.PurchaseItemDTO;

public class PurchaseDTO {

	private double runningTotal;

	private double totalVAT;

	public PurchaseDTO(double runningTotal, double totalVat, PurchaseItemDTO[] itemDTOs) {

	}

	public double getRunningTotal() {
		return 0;
	}

	public double getTotalVAT() {
		return 0;
	}

	public PurchaseItemDTO[] getItemDTOs() {
		return null;
	}

}
