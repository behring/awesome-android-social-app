package com.thoughtworks.awesomesocialapp.common.bindingadapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

import com.thoughtworks.awesomesocialapp.utils.DateFormatUtils;

import java.util.Date;

public class TextViewDataBindingAdapter {
    @BindingAdapter(value = {"android:date", "android:dateFormat"}, requireAll = false)
    public static void setDate(TextView textView, Date date, String dateFormat) {
        String dateStr;
        if (TextUtils.isEmpty(dateFormat)) {
            dateStr = DateFormatUtils.getDateStr(date);
        } else {
            dateStr = DateFormatUtils.getDateStr(date, dateFormat);
        }
        textView.setText(dateStr);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView textView, int textInt) {
        textView.setText(String.valueOf(textInt));
    }
}
