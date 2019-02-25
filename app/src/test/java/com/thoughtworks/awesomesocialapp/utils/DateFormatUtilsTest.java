package com.thoughtworks.awesomesocialapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import static org.junit.Assert.*;

public class DateFormatUtilsTest {
    @Test
    public void getDateStrByDefaultFormat() {
        final String expected = "2016-11-01 16:24:33";
        DateFormat dateFormat = new SimpleDateFormat(NetworkConstants.DATE_FORMAT, Locale.getDefault());
        try {
            Date date = dateFormat.parse(expected);
            assertEquals(expected, DateFormatUtils.getDateStr(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDateStrByCustomFormat() {
        final String CUSTOM_DATE_FORMAT = "yyyy/MM/dd HH:mm";
        final String expected = "2016/11/01 16:24";
        DateFormat dateFormat = new SimpleDateFormat(CUSTOM_DATE_FORMAT, Locale.getDefault());
        try {
            Date date = dateFormat.parse(expected);
            assertEquals(expected, DateFormatUtils.getDateStr(date, CUSTOM_DATE_FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}