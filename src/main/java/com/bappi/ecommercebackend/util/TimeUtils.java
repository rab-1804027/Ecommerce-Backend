package com.bappi.ecommercebackend.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static String createTime(){
        return formatTime(LocalDateTime.now());
    }

    public static String formatTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

}
