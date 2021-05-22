package com.example.c196projectdanadams.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy");

    public static LocalDate parseDate(String date) {
        String pattern = "M/dd/yyyy";
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(pattern);
       LocalDate dateReturn = LocalDate.parse(date, sdf);
        return dateReturn;
    }

//    public static LocalDate dateFormat(LocalDate date) {
//        String pattern = "yyyy-MM-dd";
//        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(pattern);
//        return date.parse(date.format(sdf));
//    }

}
