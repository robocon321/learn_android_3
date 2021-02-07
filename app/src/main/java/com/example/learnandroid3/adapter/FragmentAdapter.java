package com.example.learnandroid3.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.learnandroid3.utils.Fragment_A;
import com.example.learnandroid3.utils.Fragment_B;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    Fragment fragmentA, fragmentB;
    String[] titles = new String[]{"Tab A", "Tab B"};

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentA = new Fragment_A();
        fragmentB = new Fragment_B();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragmentA;
        }else {
            return fragmentB;
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
