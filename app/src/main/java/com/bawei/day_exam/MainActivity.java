package com.bawei.day_exam;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.day_exam.fragment.Frag01;
import com.bawei.day_exam.fragment.Frag02;
import com.bawei.day_exam.fragment.Frag03;
import com.bawei.day_exam.fragment.Frag04;
import com.bawei.day_exam.fragment.Frag05;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        //数据
        final ArrayList<Fragment> fragments = new ArrayList<>();
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("资讯");
        strings.add("购物车");
        strings.add("账单");
        strings.add("我的");
        tab.addTab(tab.newTab().setText(strings.get(0)));
        tab.addTab(tab.newTab().setText(strings.get(1)));
        tab.addTab(tab.newTab().setText(strings.get(2)));
        tab.addTab(tab.newTab().setText(strings.get(3)));
        tab.addTab(tab.newTab().setText(strings.get(4)));
        fragments.add(new Frag01());
        fragments.add(new Frag02());
        fragments.add(new Frag03());
        fragments.add(new Frag04());
        fragments.add(new Frag05());
        //适配器
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }
}
