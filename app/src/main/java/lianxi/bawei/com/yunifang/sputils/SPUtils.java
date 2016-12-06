package lianxi.bawei.com.yunifang.sputils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by mrzhang on 2016/12/4.
 * 张立兴
 */
public class SPUtils {


    /**
     * 做为是否登录过的工具类
     *
     */

    public static void SPUtilsPut(Context context, boolean isLogin, String SPName){
        SharedPreferences sp = context.getSharedPreferences(SPName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        SharedPreferences.Editor isLogin1 = edit.putBoolean("isLogin", true);
        edit.commit();
        Log.d("SPUtils====>","标记已经登录过存入"+isLogin1);
    }
    public static Boolean SPUtilsGet(Context context,String SPName){
        SharedPreferences sp = context.getSharedPreferences(SPName, Context.MODE_PRIVATE);
        boolean isLog = sp.getBoolean("isLogin", false);
        Log.d("SPUtils====>","返回结果"+isLog);
        return isLog;
    }
}
