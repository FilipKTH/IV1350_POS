package se.kth.iv1350.logger;

/**
 * Defines logging functionality
 */
public interface ExceptionLoggerInterface {

    /**
     * Writes to the log.
     * @param exc Exception written to the log.
     */
    void log(Exception exc);
}
