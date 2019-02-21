package com.thoughtworks.awesomesocialapp.common.bindingadapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

public final class ImageViewDataBindingAdapter {
    private ImageViewDataBindingAdapter() {
    }

    @BindingAdapter(value = {"android:imageUrl", "android:placeholder"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String url, Drawable placeholder) {
        if (TextUtils.isEmpty(url)) {
            imageView.setImageDrawable(placeholder);
        } else {
            imageView.setImageDrawable(placeholder);
        }
    }
}
