package com.phongbm.dialogfiledemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents() {
        findViewById(R.id.btn_open_dialog).setOnClickListener(this);
        findViewById(R.id.btn_open_custom_dialog).setOnClickListener(this);
        findViewById(R.id.btn_open_custom_toast).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_dialog:
                openAlertDialog();
                break;

            case R.id.btn_open_custom_dialog:
                openLoginDialog();
                break;

            case R.id.btn_open_custom_toast:
                showToast();
                break;

            default:
                break;
        }
    }

    private void openAlertDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(true)
                .setTitle(R.string.map_dialog_title)
                .setMessage(R.string.map_dialog_message)
                .setPositiveButton(R.string.all_button_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.all_button_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        dialog.show();
    }

    private void openLoginDialog() {
        LoginDialog dialog = new LoginDialog(this);
        dialog.show();
    }

    public void test() {
        // TODO
    }

    private void showToast() {
        ToastUtil toast = new ToastUtil(this);
        toast.setMessage("Hello, world!");
        toast.setIconId(R.mipmap.ic_launcher);
        toast.setMargin(0.25F, 0.25F);
        toast.show();
    }

}