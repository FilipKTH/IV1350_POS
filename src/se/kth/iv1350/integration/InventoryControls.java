package se.kth.iv1350.integration;


import java.util.List;

/**
 * Used for communication with the inventory database
 * @author Filip
 */
public class InventoryControls {
	private static final InventoryControls singleton = new InventoryControls();

	private InventoryControls(){}

	/**
	 * @return Returns the only instance of
	 * <code>InventoryControls</code>
	 */
	public static InventoryControls getSingleton(){
		return singleton;
	}
	/***
	 * Updates the external inventory system keeping
	 * tack of the number of items.
	 * @param purchaseItemDTOs Contains info of items to update
	 *                         in the inventory.
	 */
	public void updateInventory(List<PurchaseItemDTO> purchaseItemDTOs) {

	}

}
