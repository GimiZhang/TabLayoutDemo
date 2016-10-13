package com.example.gimi.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private FragmentManager fragmentManager;
    private MyFragment fragment1;
    private MyFragment fragment2;
    private MyFragment fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTitles.add("我的");
        mTitles.add("产品");
        mTitles.add("观点");

        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        fragment1 = MyFragment.newInstance("这是第一个fragment");
        fragment2 = MyFragment.newInstance("这是第二个fragment");
        fragment3 = MyFragment.newInstance("这是第三个fragment");
        fragmentsList.add(fragment1);
        fragmentsList.add(fragment2);
        fragmentsList.add(fragment3);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragmentsList,mTitles);
        tabLayout.setSelected(true);
        tabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
