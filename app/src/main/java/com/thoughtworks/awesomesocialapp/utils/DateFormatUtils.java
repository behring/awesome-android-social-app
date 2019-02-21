package com.thoughtworks.awesomesocialapp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateFormatUtils {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-mm-dd hh:mm:ss";

    private DateFormatUtils() {

    }

    public static String getDateStr(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.getDefault());
        return dateFormat.format(date);
    }

    public static String getDateStr(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(date);
    }
}
