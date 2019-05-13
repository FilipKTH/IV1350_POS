package se.kth.iv1350.model;

/**
 * Defines an observer of <code>Purchase</code>
 */
public interface PurchaseObserverInterface {
    /**
     * When the running total of <code>Purchase</code>
     * changes this method is called to update listeners.
     * @param newRunningTotal The new running total
     */
    void runningTotalUpdated(double newRunningTotal);
}
