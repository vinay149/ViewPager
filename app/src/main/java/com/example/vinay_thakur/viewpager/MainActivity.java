package com.example.vinay_thakur.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int pages=5;
    ViewPager mPager;
    PagerAdapter mPageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager=(ViewPager)findViewById(R.id.pager);
        mPageradapter=new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPageradapter);
    }

    @Override
    public void onBackPressed()
    {
        if(mPager.getCurrentItem()==0)
        {
            super.onBackPressed();
        }
        else
        {
            mPager.setCurrentItem(mPager.getCurrentItem()-1);
        }
    }
    private class SlidePagerAdapter extends FragmentStatePagerAdapter
    {
        public SlidePagerAdapter(FragmentManager fm)
        {
              super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return new PagerFragment();
        }

        @Override
        public int getCount() {
            return pages;
        }
    }
}
