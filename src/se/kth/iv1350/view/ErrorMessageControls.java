package se.kth.iv1350.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Controls the error messages shown
 * to the user.
 */
class ErrorMessageControls {
    private final static ErrorMessageControls singleton = new ErrorMessageControls();

    private ErrorMessageControls(){}

    static ErrorMessageControls getSingleton(){
        return singleton;
    }

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
