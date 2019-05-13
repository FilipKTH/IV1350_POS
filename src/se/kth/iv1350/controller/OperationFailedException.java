package se.kth.iv1350.controller;

/**
 * Thrown when any operation through the
 * controller fails.
 */
public class OperationFailedException extends Exception{
    public OperationFailedException(String msg, Exception cause){
        super(msg, cause);
    }
    public OperationFailedException(String msg){
        super(msg);
    }
}
