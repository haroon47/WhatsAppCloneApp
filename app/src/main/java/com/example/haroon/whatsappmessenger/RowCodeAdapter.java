package com.example.haroon.whatsappmessenger;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Haroon on 10/1/2017.
 */
public class RowCodeAdapter extends BaseAdapter
{
    Context c;
    ArrayList<RowVerifyCode> list;
    RowCodeAdapter(Context c)
    {
        this.c=c;
        list = new ArrayList<>();
        Resources res = c.getResources();
        String[] title = res.getStringArray(R.array.code_title);
        int[] images = {R.drawable.mymessageicon,R.drawable.mycallicon};
        for(int i=0;i<2;i++)
        {
            list.add(new RowVerifyCode(title[i],images[i]));


        }

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.codesend_layout,viewGroup,false);
        TextView t1_title = (TextView)row.findViewById(R.id.mytext);
        ImageView imageView = (ImageView)row.findViewById(R.id.imageicon);
        RowVerifyCode temp = list.get(i);
        t1_title.setText(temp.title);
        imageView.setImageResource(temp.images);

        return row;
    }
}
