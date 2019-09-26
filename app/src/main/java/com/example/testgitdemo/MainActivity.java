package com.example.testgitdemo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ShapeIndicatorView shapeIndicatorView;

    private List<ShapeFragment> fragmentList;
    private List<String> titleLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        titleLists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragmentList.add(new ShapeFragment());

        }
        titleLists.add("第一个tab");
        titleLists.add("第er个tab");
        titleLists.add("好长好长的tab啊啊啊");
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleLists.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        tabLayout.setTabsFromPagerAdapter(viewPager.getAdapter());
        shapeIndicatorView.setupWithTabLayout(tabLayout);
        shapeIndicatorView.setupWithViewPager(viewPager);
    }

    private void initView() {
        tabLayout = this.findViewById(R.id.tablayout);
        viewPager = this.findViewById(R.id.viewpager);
        shapeIndicatorView = this.findViewById(R.id.shapeIndicatorView);
    }
}
