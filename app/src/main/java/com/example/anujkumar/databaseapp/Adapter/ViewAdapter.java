package com.example.anujkumar.databaseapp.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragmentTitleList=new ArrayList<>();
    public ViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        //Add title of fragment
        fragmentTitleList.add(title);
    }
}