package com.example.haroon.whatsappmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NumberVerifyActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    EditText e1,e2;

String name,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);
        e1=(EditText)findViewById(R.id.editText);
        spinner = (Spinner)findViewById(R.id.spinner);
        e2=(EditText)findViewById(R.id.editText2);

        adapter = ArrayAdapter.createFromResource(this,R.array.defaultcountry,android.R.layout.simple_spinner_item);


        if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("name")) {
            Bundle bundle = getIntent().getExtras();
            name= bundle.getString("name");
            code= bundle.getString("code");
            e1.setText(e1.getText().toString() + code);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
            adapter2.add(name);
            spinner.setAdapter(adapter2);
            adapter2.notifyDataSetChanged();

            spinner.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    finish();
                    Intent intent = new Intent(NumberVerifyActivity.this, CountryPicker.class);
                    startActivity(intent);


                    return false;
                }
            });
        }

        else {

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            e1.setText(e1.getText().toString() + "92");

            spinner.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    finish();
                    Intent intent = new Intent(NumberVerifyActivity.this, CountryPicker.class);
                    startActivity(intent);


                    return false;
                }
            });
        }
    }

    public void number_verify(View v)
    {
        String number;
        if(code==null) {
            code="+92";
        }

            number = code + "-"+ e2.getText().toString();

            new WaitClass(this).execute(number);

       // Intent i = new Intent(NumberVerifyActivity.this,VerifyCodeActivity.class);
       // startActivity(i);
       // finish();
    }


}
