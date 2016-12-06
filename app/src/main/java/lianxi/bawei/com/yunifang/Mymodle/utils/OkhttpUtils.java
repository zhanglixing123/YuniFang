package lianxi.bawei.com.yunifang.Mymodle.utils;

import java.io.IOException;

import lianxi.bawei.com.yunifang.Mymodle.qi.OnDataLoadListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mrzhang on 2016/12/5.
 * 张立兴
 */
public class OkhttpUtils {
        public void getData(String httpurl, final OnDataLoadListener ondataloadListener){
                OkHttpClient httpclient=new OkHttpClient();
                final Request request=new Request.Builder().url(httpurl).build();
                Call call=httpclient.newCall(request);
                call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                                ondataloadListener.onFailed(e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                                if (response.isSuccessful()){

                                }
                        }
                });

        }


}
