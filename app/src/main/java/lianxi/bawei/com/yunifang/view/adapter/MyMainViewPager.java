package lianxi.bawei.com.yunifang.view.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mrzhang on 2016/12/5.
 * 张立兴
 */
public class MyMainViewPager extends FragmentPagerAdapter {
    ArrayList<Fragment> list;

    public MyMainViewPager(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
