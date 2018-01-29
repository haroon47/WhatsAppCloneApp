package com.example.haroon.whatsappmessenger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CountryPicker extends AppCompatActivity {

    Toolbar toolbar;
    ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);
        l1=(ListView)findViewById(R.id.listView);

        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setTitle("Choose a country");
        l1.setAdapter(new MyAdapter(this));
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t2_code = (TextView) view.findViewById(R.id.textView10);
                TextView t1_code = (TextView) view.findViewById(R.id.textView9);

                Intent goback = new Intent(CountryPicker.this,NumberVerifyActivity.class);
                goback.putExtra("name",t1_code.getText().toString());
                goback.putExtra("code",t2_code.getText().toString());
                startActivity(goback);
                finish();

            }
        });

    }

}
