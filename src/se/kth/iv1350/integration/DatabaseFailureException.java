package se.kth.iv1350.integration;

/**
 * Thrown when no successful connection
 * to the item database is established
 */
public class DatabaseFailureException extends RuntimeException {
    public DatabaseFailureException(String msg){
        super(msg);
    }
}
