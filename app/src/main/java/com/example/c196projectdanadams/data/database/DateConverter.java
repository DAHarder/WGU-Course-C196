package com.example.c196projectdanadams.data.database;

import androidx.room.TypeConverter;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter {

    @TypeConverter
    public static LocalDate toDate(String dateString) {
        return dateString == null ? null : LocalDate.parse(dateString);
    }

    @TypeConverter
    public static String toDateString(LocalDate date) {
        return date == null ? null : date.toString();
    }
}