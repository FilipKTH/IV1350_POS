package se.kth.iv1350.integration;

/**
 * Used for communication with the customer database
 * @author Filip
 */
public class CustomerDatabaseControls {
	private static final CustomerDatabaseControls singleton = new CustomerDatabaseControls();

	/**
	 * @return Returns the only instance of
	 * <code>CustomerDatabaseControls</code>
	 */
	static CustomerDatabaseControls getSingleton(){
		return singleton;
	}

	CustomerDTO findCustomerByID(String customerID) {
		return null;
	}

}
