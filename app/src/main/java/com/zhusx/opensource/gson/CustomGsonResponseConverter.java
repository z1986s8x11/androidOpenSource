package com.zhusx.opensource.gson;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CustomGsonResponseConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String body = value.string();
            try {
                return adapter.fromJson(body);
            } catch (Exception e) {
                if (!TextUtils.isEmpty(body)) {
                    try {
                        // 获取json中的code，对json进行预处理
                        JSONObject json = new JSONObject(body);
                        int code = json.optInt("code");//TODO 根据实际接口情况来
                        // 当code不为0时，设置data为{}，这样转化就不会出错了
                        if (code != 0) {
                            json.put("data", null);
                            body = json.toString();
                        }
                        return adapter.fromJson(body);
                    } catch (JSONException ex) {
                        ex.printStackTrace();
                    }
                }
                throw e;
            }
        } finally {
            value.close();
        }
    }
}