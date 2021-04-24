package com.jatin.tabbedactivitydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Intialize views
        initViews();

        // Creating Adapter
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        // Add data to adapter
        adapter.addFragment(new ChatFragment(),"Chat");
        adapter.addFragment(new StatusFragment(),"Status");
        adapter.addFragment(new CallFragment(),"Call");

        // set Adapter to view pager
        viewPager.setAdapter(adapter);
        // set tablayout with view pager
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViews() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

}