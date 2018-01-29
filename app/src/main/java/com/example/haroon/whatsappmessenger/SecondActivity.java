package com.example.haroon.whatsappmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void open_smsVerify(View v)
    {
        Intent i = new Intent(SecondActivity.this,NumberVerifyActivity.class);
        startActivity(i);
        finish();

    }

}
