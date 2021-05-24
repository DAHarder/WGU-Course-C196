package com.example.c196projectdanadams.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.US);

    public static LocalDate parseDate(String date) {
        String pattern = "M/d/yyyy";
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern(pattern);
       LocalDate dateReturn = LocalDate.parse(date, sdf);
        return dateReturn;
    }

}
