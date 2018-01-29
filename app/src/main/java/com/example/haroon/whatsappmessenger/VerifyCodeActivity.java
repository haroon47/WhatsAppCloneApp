package com.example.haroon.whatsappmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VerifyCodeActivity extends AppCompatActivity implements TextWatcher{
    ListView l1;
    TextView t11,t12;
    EditText e3;
String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        l1 = (ListView)findViewById(R.id.listView2);
        t11=(TextView)findViewById(R.id.textView11);
        t12=(TextView)findViewById(R.id.textView12);
        e3 = (EditText)findViewById(R.id.editText3);
        l1.setAdapter(new RowCodeAdapter(this));
        Bundle bundle = getIntent().getExtras();
        number= bundle.getString("number");
        e3.addTextChangedListener(this);


        t11.setText(t11.getText().toString() + number);
        t12.setText(t12.getText().toString() + number);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(charSequence.length()==6)
            {
                Intent intent = new Intent(VerifyCodeActivity.this,MainPageActivity.class);
                startActivity(intent);
                finish();
            }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
