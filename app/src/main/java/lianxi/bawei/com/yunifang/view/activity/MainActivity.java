package lianxi.bawei.com.yunifang.view.activity;


import android.os.Bundle;

import lianxi.bawei.com.yunifang.R;
import lianxi.bawei.com.yunifang.view.ZDYview.ImageAndText;
import lianxi.bawei.com.yunifang.view.adapter.MyMainViewPager;
import lianxi.bawei.com.yunifang.view.fragment.F1;
import lianxi.bawei.com.yunifang.view.fragment.F2;
import lianxi.bawei.com.yunifang.view.fragment.F3;
import lianxi.bawei.com.yunifang.view.fragment.F4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    //    viewpager
    private ViewPager viewpager_main;
    //   自定义view 我的
    private ImageAndText imageAndText_wode;
    //   自定义view 购物车
    private ImageAndText imageandtext_gouwuche;
    //   自定义view 分类
    private ImageAndText imageandtext_fenlei;
    //   自定义view 首页
    private ImageAndText imageandtext_shouye;
//    fragment 集合
    private ArrayList<Fragment> list_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list_fragment = new ArrayList<Fragment>();
//        添加fragment到集合
        list_fragment.add(new F1());
        list_fragment.add(new F2());
        list_fragment.add(new F3());
        list_fragment.add(new F4());
//        设置适配器
        viewpager_main.setAdapter(new MyMainViewPager(getSupportFragmentManager(), list_fragment));
//        viewpager监听
        viewpager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
//    初始化控件
    private void initView() {
        viewpager_main = (ViewPager) findViewById(R.id.viewpager_main);
        imageandtext_shouye = (ImageAndText) findViewById(R.id.imageandtext_shouye);
        imageandtext_shouye.setImgResource(R.mipmap.bottom_tab_classify_normal);
        imageandtext_shouye.setText("首页");


        imageandtext_fenlei = (ImageAndText) findViewById(R.id.imageandtext_fenlei);
        imageandtext_fenlei.setImgResource(R.mipmap.bottom_tab_home_normal);
        imageandtext_fenlei.setText("分类");

        imageandtext_gouwuche = (ImageAndText) findViewById(R.id.imageandtext_gouwuche);
        imageandtext_gouwuche.setImgResource(R.mipmap.bottom_tab_shopping_normal);
        imageandtext_gouwuche.setText("购物车");

        imageAndText_wode = (ImageAndText) findViewById(R.id.imageandtext_wode);
        imageAndText_wode.setText("我的");
        imageAndText_wode.setImgResource(R.mipmap.bottom_tab_user_normal);
    }
}
