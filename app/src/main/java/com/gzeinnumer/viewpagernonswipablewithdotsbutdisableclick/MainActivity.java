package com.gzeinnumer.viewpagernonswipablewithdotsbutdisableclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.gzeinnumer.viewpagernonswipablewithdotsbutdisableclick.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout dotsTab;
    ViewPager viewPager;
    public static TabLayout dotsTabStatic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsTab = findViewById(R.id.dots_tab);
        dotsTabStatic = dotsTab;
        viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPagerAdapter.addFragment(FirstFragment.newInstance());
        viewPagerAdapter.addFragment(SecondFragment.newInstance());

        viewPager.setAdapter(viewPagerAdapter);
        dotsTab.setupWithViewPager(viewPager);

        LinearLayout tabStrip = ((LinearLayout) dotsTab.getChildAt(0));
        for (int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }
    }
}