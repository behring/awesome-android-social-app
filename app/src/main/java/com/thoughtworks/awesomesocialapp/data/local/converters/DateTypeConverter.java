package com.thoughtworks.awesomesocialapp.data.local.converters;

import android.arch.persistence.room.TypeConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;

public class DateTypeConverter {
    @TypeConverter
    public static Date toDate(String value) {
        try {
            return new SimpleDateFormat(NetworkConstants.DATE_FORMAT, Locale.getDefault())
                    .parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    @TypeConverter
    public static String toStr(Date value) {
        if (value == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(NetworkConstants.DATE_FORMAT,
                Locale.getDefault());
        return dateFormat.format(value);
    }
}
