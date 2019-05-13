package se.kth.iv1350.integration;

/**
 * Thrown when trying to fetch an item
 * from a database with a none existing ID
 */
public class NoMatchingIDException extends Exception {
    /**
     * Creates an instance with a message specifying
     * what item ID wasn't able to be found in the
     * database
     * @param itemID Item ID with no match
     */
    public NoMatchingIDException(String itemID){
        super(itemID + " could not be found in the database.");
    }
}
