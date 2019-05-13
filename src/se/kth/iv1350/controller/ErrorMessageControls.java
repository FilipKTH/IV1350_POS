package se.kth.iv1350.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Controls the error messages shown
 * to the user.
 */
public class ErrorMessageControls {
    void showErrorMessage(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(", ERROR:\n");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

    private String createTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
