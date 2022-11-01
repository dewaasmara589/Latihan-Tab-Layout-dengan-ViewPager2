package com.dewa.mytablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    // Mengirimkan Data
    String appName;

    public void setAppName(String appName){
        this.appName = appName;
    }


    public SectionsPagerAdapter(AppCompatActivity activity){
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        Cara 1 Jika dengan membuat banyak fragment
//        Fragment fragment = null;
//        switch (position) {
//            case 0:
//                fragment = new HomeFragment();
//                break;
//            case 1:
//                fragment = new ProfileFragment();
//                break;
//        }
//        return fragment;

//        Cara 2 Tab Layout With One Fragment
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(HomeFragment.ARG_SECTION_NUMBER, position+1);
        bundle.putString(HomeFragment.ARG_NAME, appName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        // Cara 1 dengan hanya 2 Fragment
//        return 2;
        // Cara 2
        return 3;
    }
}
