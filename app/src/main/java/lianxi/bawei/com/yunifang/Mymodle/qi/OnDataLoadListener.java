package lianxi.bawei.com.yunifang.Mymodle.qi;

import java.util.List;

import lianxi.bawei.com.yunifang.Mymodle.bean.MyBean;

/**
 * Created by mrzhang on 2016/12/5.
 * 张立兴
 */

public interface OnDataLoadListener {
    void onSuccess(List<MyBean> list);
    void onFailed(String str);
}
