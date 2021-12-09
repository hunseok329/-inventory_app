package com.example.testap;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;
import android.widget.ProgressBar;

//로딩시 프로그래스바 생성

public class ProgressCircleDialog extends Dialog {
    public static final boolean DEF_CANCELABLE = true ;
    public static final boolean DEF_CANNOT_CANCELABLE = false ;


    public static ProgressCircleDialog show(Context context, CharSequence title, CharSequence message) {
        return show(context, title, message, DEF_CANCELABLE);
    }

    public static ProgressCircleDialog show(Context context, CharSequence title, CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, DEF_CANCELABLE, null);
    }

    public static ProgressCircleDialog show(Context context, CharSequence title, CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }


    public static ProgressCircleDialog show(Context context, CharSequence title,
                                            CharSequence message, boolean indeterminate,
                                            boolean cancelable, OnCancelListener cancelListener) {
        ProgressCircleDialog dialog = new ProgressCircleDialog(context);
        dialog.setTitle(title);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);

        dialog.addContentView(new ProgressBar(context), new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }

    public ProgressCircleDialog(Context context) {
        super(context, R.style.NewDialog);
    }
}


