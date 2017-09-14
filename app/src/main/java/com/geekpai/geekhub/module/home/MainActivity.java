package com.geekpai.geekhub.module.home;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.geekpai.geekhub.R;
import com.geekpai.geekhub.andframe.ui.base.BaseActivity;


/**
 * description:
 * created by geekpai on 2017/8/26.
 * email: geekpai@qq.com
 */

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private NavigationView navigationView;
    private FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private TabLayout mTabLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("GeekHub");
        navigationView = (NavigationView) findViewById(R.id.naviView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hi Geekhub! ", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Snackbar.make(navigationView, "点我干啥？", Snackbar.LENGTH_LONG).setAction("敢再点一下吗？", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "老子点了咋地 ", Snackbar.LENGTH_LONG).setAction("hehe", null).show();
                    }
                }).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
