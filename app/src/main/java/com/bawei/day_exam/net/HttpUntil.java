package com.bawei.day_exam.net;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.day_exam.MyApplication;

import java.util.Map;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HttpUntil {
    private static final HttpUntil ourInstance = new HttpUntil();

    public static HttpUntil getInstance() {
        return ourInstance;
    }

    private HttpUntil() {
    }

    @SuppressLint("StaticFieldLeak")
    public void doHttpGet(String surl, final CallBackPost post) {
        StringRequest request = new StringRequest(Request.Method.GET, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        });
        MyApplication.getQueue().add(request);
    }

    //============================================================
    public void doHttpPost(String surl, final CallBackPost post) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        });
        MyApplication.getQueue().add(stringRequest);
    }
}
