package com.bawei.day_exam.mvp.Home;

import com.bawei.day_exam.mvp.Home.IMainContract;
import com.bawei.day_exam.net.CallBackPost;
import com.bawei.day_exam.net.HttpUntil;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class MainModelImpl implements IMainContract.IMainModel {

    private final HttpUntil until;

    public MainModelImpl() {
        until = HttpUntil.getInstance();
    }

    @Override
    public void doHttpGet(String url, CallBackPost post) {
        until.doHttpGet(url, post);
    }
}
