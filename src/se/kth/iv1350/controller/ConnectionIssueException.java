package se.kth.iv1350.controller;

/**
 * Thrown when no successful connection
 * to the item database is established.
 * This goes to the view.
 */
public class ConnectionIssueException extends Exception {
    public ConnectionIssueException(String msg){
        super(msg);
    }
}
