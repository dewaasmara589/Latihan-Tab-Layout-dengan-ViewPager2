package com.dewa.mytablayout;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cara 1
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager2,
                (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))
        ).attach();

        if (getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }

        // Cara 2 untuk menerima Data
        SectionsPagerAdapter sectionsPagerAdapter2 = new SectionsPagerAdapter(this);
        sectionsPagerAdapter2.setAppName(getResources().getString(R.string.app_name));
    }
}