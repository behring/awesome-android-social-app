package com.thoughtworks.awesomesocialapp.common.view;

import android.app.Dialog;
import android.content.Context;
import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.databinding.ProgressDialogBinding;

public class ProgressDialog extends Dialog {

    private ProgressDialogBinding binding;

    public ProgressDialog(Context context) {
        this(context, R.style.ProgressDialogWindowStyle);
    }

    public ProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        binding = ProgressDialogBinding.bind(getLayoutInflater().inflate(R.layout.progress_dialog,
                null));
        setContentView(binding.getRoot());
    }


    ProgressDialogBinding getBinding() {
        return binding;
    }

    public static class Builder {
        private final Context context;
        private CharSequence text;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public ProgressDialog create() {
            ProgressDialog dialog = new ProgressDialog(context);
            dialog.getBinding().text.setText(text);
            return dialog;
        }
    }
}
