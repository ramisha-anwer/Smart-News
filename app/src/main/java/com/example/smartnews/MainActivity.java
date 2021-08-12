package com.example.smartnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mscience,ment,mtech;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    String url ="https://newsapi.org/v2/everything?q=apple&from=2021-07-17&to=2021-07-17&sortBy=popularity&apiKey=8d0770f335424606a3a0be143fd26f08";

        tabLayout= findViewById(R.id.tablayout);
        mhome= findViewById(R.id.home);
        mhealth= findViewById(R.id.health);
        msports= findViewById(R.id.sports);
        mscience= findViewById(R.id.science);
        ment= findViewById(R.id.ent);
        mtech= findViewById(R.id.tech);
        toolbar=findViewById(R.id.toolbar);
        ViewPager viewPager= findViewById(R.id.fragmentcontainer);

        setSupportActionBar(toolbar);

        pagerAdapter= new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
            pagerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}