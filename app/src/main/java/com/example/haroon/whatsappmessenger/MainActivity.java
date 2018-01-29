package com.example.haroon.whatsappmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void second_activity(View v)
    {
        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(i);
    }

}
