package com.jaja.springindicator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.google.common.collect.Lists;
import com.jaja.springindicator.widget.ScrollerViewPager;
import com.jaja.springindicator.widget.SpringIndicator;

import java.util.List;

import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerModelManager;


public class MainActivity extends ActionBarActivity {

    ScrollerViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        PagerModelManager manager = new PagerModelManager();
        manager.addCommonFragment(GuideFragment.class, getBgRes(), getTitles());
        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        // just set viewPager
        springIndicator.setViewPager(viewPager);

    }

    private List<String> getTitles(){
        return Lists.newArrayList("1", "2", "3", "4");
    }

    private List<Integer> getBgRes(){
        return Lists.newArrayList(R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg4);
    }

}
