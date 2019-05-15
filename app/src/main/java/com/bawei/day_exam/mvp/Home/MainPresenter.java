package com.bawei.day_exam.mvp.Home;

import com.bawei.day_exam.mvp.Home.IMainContract;
import com.bawei.day_exam.mvp.Home.MainModelImpl;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class MainPresenter implements IMainContract.IMainPresenter {

    private IMainContract.IMainView view;
    private IMainContract.IMainModel model;

    @Override
    public void attach(IMainContract.IMainView mainView) {
        view = mainView;
        model = new MainModelImpl();
    }

    @Override
    public void dattch() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void getBanner(String surl) {

    }

    @Override
    public void getList(String surl) {

    }
}
