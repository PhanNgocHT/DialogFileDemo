package com.phongbm.dialogfiledemo;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtil extends Toast {
    private ImageView imgIcon;
    private TextView txtMessage;

    private int iconId;
    private String message;

    public ToastUtil(Context context) {
        super(context);
        setupToast(context);
    }

    private void setupToast(Context context) {
        // inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.view_toast, null);
        setView(view);

        imgIcon = (ImageView) view.findViewById(R.id.img_icon);
        txtMessage = (TextView) view.findViewById(R.id.txt_message);

        setDuration(Toast.LENGTH_SHORT);
        setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
        imgIcon.setImageResource(iconId);
    }

    public void setMessage(String message) {
        this.message = message;
        txtMessage.setText(message);
    }

}