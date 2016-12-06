package lianxi.bawei.com.yunifang.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import lianxi.bawei.com.yunifang.R;
import lianxi.bawei.com.yunifang.sputils.SPUtils;
import lianxi.bawei.com.yunifang.view.ZDYview.ImageViewLine;
import lianxi.bawei.com.yunifang.view.adapter.MyYDVPAdapter;

public class YinDaoYe extends AppCompatActivity {

    private ViewPager viewpager_yd;
    private ImageView image_yd;
    private List<ImageView> imagelist;
    private ImageViewLine imageZDY;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yin_dao_ye);
        Boolean zlx = SPUtils.SPUtilsGet(YinDaoYe.this, "zlx");
        if (zlx){
           mHandler.sendEmptyMessageDelayed(2,2000);
        }else {
            SPUtils.SPUtilsPut(YinDaoYe.this, true, "zlx");
            Message msg = Message.obtain();
            msg.what = 0;
            mHandler.sendMessageDelayed(msg, 2000);

        }
        initView();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initData() {
        imagelist = new ArrayList<ImageView>();
        ImageView ima = new ImageView(YinDaoYe.this);
        ima.setImageResource(R.mipmap.xiaomi_guidance_1);
        imagelist.add(ima);

        ImageView ima2 = new ImageView(YinDaoYe.this);
        ima2.setImageResource(R.mipmap.xiaomi_guidance_2);
        imagelist.add(ima2);

        ImageView ima3 = new ImageView(YinDaoYe.this);
        ima3.setImageResource(R.mipmap.xiaomi_guidance_3);
        imagelist.add(ima3);

        ImageView ima4 = new ImageView(YinDaoYe.this);
        ima4.setImageResource(R.mipmap.xiaomi_guidance_4);
        imagelist.add(ima4);

        ImageView ima5 = new ImageView(YinDaoYe.this);
        ima5.setImageResource(R.mipmap.xiaomi_guidance_5);
        imagelist.add(ima5);

        viewpager_yd.setAdapter(new MyYDVPAdapter((ArrayList<ImageView>) imagelist, YinDaoYe.this));
        viewpager_yd.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = viewpager_yd.getCurrentItem();
                if (currentItem == imagelist.size()-1) {
                    imageZDY.setVisibility(View.VISIBLE);
                }
                imageZDY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        AnimatorSet set=(AnimatorSet) AnimatorInflater.loadAnimator(YinDaoYe.this,R.);
//                        Animation a=new Animation();
                        Animation animation = AnimationUtils.loadAnimation(YinDaoYe.this, R.anim.set);
                        imageZDY.startAnimation(animation);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Intent intent=new Intent(YinDaoYe.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        image_yd = (ImageView) findViewById(R.id.image_yd);
        image_yd.setImageResource(R.mipmap.loading_icon);
        imageZDY = (ImageViewLine) findViewById(R.id.imageZDY_yd);
        viewpager_yd = (ViewPager) findViewById(R.id.viewpager_yd);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            if (what==0){
                    image_yd.setVisibility(View.GONE);
                    viewpager_yd.setVisibility(View.VISIBLE);
                    initData();


            }if (msg.what==2){
                Intent intent=new Intent(YinDaoYe.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("YinDaoYe Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
