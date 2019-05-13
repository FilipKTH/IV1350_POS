package se.kth.iv1350.integration;

/**
 * Used for communication with the item database
 * @author Filip
 */
public class ItemDatabaseControls {
	//only used for testing and simulating database
	final static int NR_OF_ITEMS = 5;
	private static PurchaseItemDTO[] database;

	/***
	 * Finds item based on its id in the inventory database
	 * @param itemID Id to find in database
	 * @return Returns the matching item from the database
	 * @throws NoMatchingIDException	If there is no item
	 * 								 	in the database
	 * 								 	matching the itemID.
	 */
	public static PurchaseItemDTO scanItem(String itemID)
			throws NoMatchingIDException{
		if (itemID == null)
			return null;
		createItemsForDatabase();

		return returnItemFromDatabase(itemID);
	}

	//only used for testing purposes
	private static void createItemsForDatabase(){
		database = new PurchaseItemDTO[NR_OF_ITEMS];
		database[0] = new PurchaseItemDTO(10,2,1,"apple","This is an apple");
		database[1] = new PurchaseItemDTO(5,1,1,"food","This is food");
		database[2] = new PurchaseItemDTO(100,30,1,"desk","This is a desk");
		database[3] = new PurchaseItemDTO(58,5,1,"pasta","This is pasta");
		database[4] = new PurchaseItemDTO(32,5,1,"bed","This is a bed");
	}

	private static PurchaseItemDTO returnItemFromDatabase(String itemID)
			throws NoMatchingIDException{
		for (int i = 0; i < NR_OF_ITEMS; i++)
			if (itemID.equals(database[i].getItemID()))
				return database[i];
		throw new NoMatchingIDException(itemID);
	}

}
