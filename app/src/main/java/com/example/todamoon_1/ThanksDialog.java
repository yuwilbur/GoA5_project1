package com.example.todamoon_1;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ThanksDialog extends Dialog implements View.OnClickListener {
    Activity activity;

    public ThanksDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.thanks);
        Button close = findViewById(R.id.close);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
