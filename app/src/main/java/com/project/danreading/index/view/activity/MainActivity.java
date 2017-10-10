package com.project.danreading.index.view.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.project.danreading.R;
import com.project.danreading.common.base.BaseActivity;
import com.project.danreading.common.model.entity.Item;
import com.project.danreading.common.utils.AppUtil;
import com.project.danreading.common.view.VerticalViewPager;
import com.project.danreading.common.view.adapter.VerticalPagerAdapter;
import com.project.danreading.common.di.components.DaggerMainComponent;
import com.project.danreading.index.di.modules.MainModule;
import com.project.danreading.index.presenter.MainContract;
import com.project.danreading.index.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.vvp)
    VerticalViewPager mVvp;
    @BindView(R.id.title_tv)
    TextView mTitleTv;
    private ActionBarDrawerToggle mDrawerToggle;

    public VerticalPagerAdapter mPagerAdapter;
    @Inject
    public MainPresenter mMainPresenter;
    @Inject
    public AppUtil mAppUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolBar();
        initPage();
        loadData(1, 0, "0", "0");
    }

    private void loadData(int page, int mode, String pageId, String createTime) {
        mMainPresenter.getListByPage(page, mode, pageId, mAppUtil.getDeviceId(), createTime);
    }

    /**
     * 初始化toolbar相关
     */
    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationIcon(R.drawable.column);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_string, R.string.close_string) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        Resources resource = (Resources) getBaseContext().getResources();
        ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.navigation_menu_item_color);
        mNavigationView.setItemTextColor(csl);
    }

    private void initPage() {
        DaggerMainComponent.builder().appComponent(getAppComponents()).netComponent(getNetComponents()).mainModule(new MainModule(this)).build().inject(this);
        mPagerAdapter = new VerticalPagerAdapter(getSupportFragmentManager());
        mVvp.setAdapter(mPagerAdapter);
    }


    @Override
    public void initStatus() {
        StatusBarUtil.setTranslucent(this, 112);
    }

    @Override
    public void updateListUi(List<Item> lists) {
        mPagerAdapter.setDataList(lists);
        mPagerAdapter.notifyDataSetChanged();
    }
}
