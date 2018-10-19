package com.sean.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNTD;
    private TextView us;
    private TextView jp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNTD = findViewById(R.id.ntd);
        us = findViewById(R.id.us);
        jp = findViewById(R.id.jp);
    }

    public void go(View view){
        String ntd = edNTD.getText().toString();
        if (ntd==null||ntd.equals("")){ //判斷是否為空值
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        } else {
            float TW = Float.parseFloat(ntd);
            float US = TW / 30.9f;
            float JP = TW / 0.26f;
            us.setText("" + US);
            jp.setText("" + JP);
            new AlertDialog.Builder(this)
                    .setTitle("貨幣換算")
                    .setMessage("台幣：" + TW + "\n" + "美金：" + US + "\n" + "日幣：" + JP)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNTD.setText("");
                        }
                    })
                    .show();
        }
    }
}
