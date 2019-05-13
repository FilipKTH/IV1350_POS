package se.kth.iv1350.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class takes care of logging
 * errors in the program.
 */
public class FileLogger implements ExceptionLoggerInterface{
    private static final String LOG_FILE_NAME = "purchase-error-log.txt";
    private PrintWriter logFile;

    public FileLogger() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME));
    }
    @Override
    public void log(Exception exc) {
        StringBuilder errorLogMsg = new StringBuilder();
        errorLogMsg.append(createTime());
        errorLogMsg.append(", An exception was thrown:\n");
        errorLogMsg.append(exc.getMessage());
        logFile.println(errorLogMsg);
        exc.printStackTrace(logFile);
    }

    private String createTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
