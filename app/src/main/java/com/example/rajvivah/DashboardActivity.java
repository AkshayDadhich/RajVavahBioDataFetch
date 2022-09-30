package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {


    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("Home");
        //  getSupportActionBar().setSubtitle("Report Offence");
        page = findViewById(R.id.my_pager);
        tabLayout = findViewById(R.id.my_tablayout);


        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<>();
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s1, "Slider 1 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s2, "Slider 2 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s3, "Slider 3 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s4, "Slider 4 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s4, "Slider 5 Title"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.s5, "Slider 6 Title"));

        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(), 2000, 3000);
        tabLayout.setupWithViewPager(page, true);

    }


    private void showBottomSheetDialog() {
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            DashboardActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem() < listItems.size() - 1) {
                        page.setCurrentItem(page.getCurrentItem() + 1);
                    } else
                        page.setCurrentItem(0);
                }
            });
        }
    }


}