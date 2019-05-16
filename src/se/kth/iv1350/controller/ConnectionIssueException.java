package se.kth.iv1350.controller;

/**
 * Thrown when no successful connection
 * to the item database is established.
 * This goes to the view.
 */
public class ConnectionIssueException extends Exception {
    /**
     * Creates an instance with as a
     * representation of the connection issue.
     * @param msg Simplified message of the
     *            connection issue.
     */
    public ConnectionIssueException(String msg){
        super(msg);
    }
}
