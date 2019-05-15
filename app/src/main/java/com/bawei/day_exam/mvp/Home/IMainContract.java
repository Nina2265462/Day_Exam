package com.bawei.day_exam.mvp.Home;

import com.bawei.day_exam.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public interface IMainContract {
    public interface IMainView {
        void BannerShow(String result);

        void ListShow(String result);
    }

    public interface IMainModel {
        void doHttpGet(String url, CallBackPost post);
    }

    public interface IMainPresenter {
        void attach(IMainView mainView);

        void dattch();

        void getBanner(String surl);

        void getList(String surl);
    }
}
