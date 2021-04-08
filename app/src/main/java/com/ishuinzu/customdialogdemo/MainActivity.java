package com.ishuinzu.customdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show Custom Dialog
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_custom_dialog);
        dialog.setCancelable(false);

        //Layout Params
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        //Cancel Button
        (dialog.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Close Dialog!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //Logout Button
        (dialog.findViewById(R.id.btnLogout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logged Out!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //Setting Layout Params
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }
}