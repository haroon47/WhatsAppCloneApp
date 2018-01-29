package com.example.haroon.whatsappmessenger;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Haroon on 9/30/2017.
 */
public class MyAdapter extends BaseAdapter
{
    Context context;
    ArrayList<SingleRow> arrayList;

    MyAdapter(Context context)
    {
        this.context=context;
        arrayList = new ArrayList<>();
        Resources res = context.getResources();
        String[] country_name = res.getStringArray(R.array.country_names);
        String[] country_code = res.getStringArray(R.array.country_code);

        for(int i=0;i<country_name.length;i++)
        {
            arrayList.add(new SingleRow(country_name[i],country_code[i]));

        }

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row =inflater.inflate(R.layout.country_listview,viewGroup,false);
        TextView t1_name = (TextView)row.findViewById(R.id.textView9);
        TextView t2_code = (TextView)row.findViewById(R.id.textView10);
        SingleRow temp = arrayList.get(i);
        t1_name.setText(temp.country_name);
        t2_code.setText(temp.country_code);

        return row;
    }
}
