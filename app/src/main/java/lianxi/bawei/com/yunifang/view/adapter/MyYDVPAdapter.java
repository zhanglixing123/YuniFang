package lianxi.bawei.com.yunifang.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrzhang on 2016/12/5.
 * 张立兴
 */
public class MyYDVPAdapter extends PagerAdapter {
    private List<ImageView> list;
    private Context context;

    public MyYDVPAdapter(ArrayList<ImageView> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView(list.get(position % list.size()));
    }

    /**
     * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
     */
    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager) container).addView(list.get(position % list.size()), 0);
        return list.get(position % list.size());
    }


}
