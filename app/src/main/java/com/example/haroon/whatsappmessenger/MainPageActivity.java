package com.example.haroon.whatsappmessenger;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainPageActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager vp;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setTitle("WhatsApp");

        vp = (ViewPager)findViewById(R.id.viewpager);
        setTitle("WhatsApp");
        setupViewPager(vp);
        tabLayout.setupWithViewPager(vp);



    }
    public void setupViewPager(ViewPager vp)
    {
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());

        vpa.addFragment(new ChatsFragment(),"CHATS");
        vpa.addFragment(new StatusFragment(),"STATUS");
        vpa.addFragment(new CallsFragment(),"CALLS");

        vp.setAdapter(vpa);

    }

}
