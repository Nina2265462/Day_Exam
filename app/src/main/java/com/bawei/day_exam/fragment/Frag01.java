package com.bawei.day_exam.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.day_exam.R;
import com.bawei.day_exam.adapter.home.HomeAdapter;
import com.bawei.day_exam.base.BaseFragment;
import com.bawei.day_exam.bean.BannerBean;
import com.bawei.day_exam.bean.HomeList;
import com.bawei.day_exam.mvp.Home.IMainContract;
import com.bawei.day_exam.mvp.Home.MainPresenter;
import com.google.gson.Gson;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class Frag01 extends BaseFragment implements IMainContract.IMainView {

    private RecyclerView recyclerView;
    private IMainContract.IMainPresenter presenter;
    public static String home_banner = "http://172.17.8.100/small/commodity/v1/bannerShow";

    public static String home_list = "http://172.17.8.100/small/commodity/v1/commodityList";
    private HomeAdapter adapter;


    @Override
    public int initLayout() {
        return R.layout.frag01;
    }

    @Override
    public void initView() {
        recyclerView = initId(R.id.recy);
        presenter = new MainPresenter();
        presenter.attach(this);
        //设置布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        //适配器
        adapter = new HomeAdapter(mActivity);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        presenter.getBanner(home_banner);
        presenter.getList(home_list);
      
    }

    @Override
    public void BannerShow(String result) {
        Gson gson = new Gson();
        BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
        adapter.updataBanner(bannerBean);
    }

    @Override
    public void ListShow(String result) {
        Gson gson = new Gson();
        HomeList homeList = gson.fromJson(result, HomeList.class);
        adapter.updataHome(homeList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dattch();
    }
}
