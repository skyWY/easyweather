package com.weather.byhieg.easyweather;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.byhieglibrary.Activity.BaseActivity;
import com.weather.byhieg.easyweather.Adapter.DrawerListAdapter;
import com.weather.byhieg.easyweather.Bean.DrawerContext;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    public Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;
    @Bind(R.id.recyclerview)
    public RecyclerView recyclerView;

    private DrawerListAdapter drawerListAdapter;

    private ArrayList<DrawerContext> drawerList = new ArrayList<>();

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        int [] images = { R.drawable.ic_trending_up_black_24dp,
                          R.drawable.ic_settings_black_24dp,
                          R.drawable.ic_share_black_24dp,
                          R.drawable.ic_help_black_24dp,
                          R.drawable.ic_hourglass_empty_black_24dp,
                          R.drawable.ic_wikipedia,
                          R.drawable.ic_more_black_24dp};

        int[] names = { R.string.future,
                        R.string.setting,
                        R.string.share,
                        R.string.help,
                        R.string.laboratory,
                        R.string.wiki,
                        R.string.about};

        for(int i = 0 ;i < 7;i++) {
            DrawerContext drawerContext = new DrawerContext();
            drawerContext.setImage(images[i]);
            drawerContext.setName(names[i]);
            drawerList.add(drawerContext);
        }

        drawerListAdapter = new DrawerListAdapter(drawerList);

    }

    @Override
    public void initView() {
        toolbar.setTitle("成都");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(drawerListAdapter);

    }

    @Override
    public void initEvent() {
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feedback:
                        break;

                    case R.id.location:
                        break;

                    case R.id.like:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
