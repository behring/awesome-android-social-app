package com.thoughtworks.awesomesocialapp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;

public final class DateFormatUtils {

    private DateFormatUtils() {

    }

    public static String getDateStr(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(NetworkConstants.DATE_FORMAT,
                Locale.getDefault());
        return dateFormat.format(date);
    }

    public static String getDateStr(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(date);
    }
}
