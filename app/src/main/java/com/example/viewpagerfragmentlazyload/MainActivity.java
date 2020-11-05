package com.example.viewpagerfragmentlazyload;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] titles = new String[]{"最新", "热门", "我的"};
    Fragment1 fragment1, fragment2, fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewpager = findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(2);
        TabLayout tablayout = findViewById(R.id.tablayout);

        for (int i = 0; i < titles.length; i++) {
            tablayout.addTab(tablayout.newTab());
            tablayout.getTabAt(i).setText(titles[i]);
        }
        tablayout.setupWithViewPager(viewpager);

        ArrayList<Fragment> list = new ArrayList<>();
//        Fragment1 fragment1 = new Fragment1(0);
//        Bundle bundle=new Bundle();
//        bundle.putInt("pos",0);
////        fragment1.setArguments(bundle);
//        list.add(fragment1);
//
//        Bundle bundle2=new Bundle();
//        bundle.putInt("pos",1);
//        Fragment1 fragment2 = new Fragment1(1);
////        fragment2.setArguments(bundle2);
//        list.add(fragment2);
//
//        Bundle bundle3=new Bundle();
//        bundle.putInt("pos",2);
//        Fragment1 fragment3 = new Fragment1(2);
////        fragment3.setArguments(bundle3);
//        list.add(fragment3);


        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                if (i == 0) {
                    if (fragment1 == null) {
                        fragment1 = new Fragment1(0);
                    }
                    return fragment1;
                } else if (i == 1) {
                    if (fragment2 == null) {
                        fragment2 = new Fragment1(1);
                    }
                    return fragment2;
                } else if (i == 2) {
                    if (fragment3 == null) {
                        fragment3 = new Fragment1(2);
                    }
                    return fragment3;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }
}