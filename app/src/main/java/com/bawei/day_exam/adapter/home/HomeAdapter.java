package com.bawei.day_exam.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bawei.day_exam.R;
import com.bawei.day_exam.bean.BannerBean;
import com.bawei.day_exam.bean.HomeList;
import com.bawei.day_exam.holder.home.BannerHolder;
import com.bawei.day_exam.holder.home.MlssHolder;
import com.bawei.day_exam.holder.home.PzshHolder;
import com.bawei.day_exam.holder.home.RxxpHolder;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private BannerBean banner;
    private HomeList list;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void updataBanner(BannerBean bannerBean) {
        this.banner = banner;
        notifyDataSetChanged();
    }

    public void updataHome(HomeList homeList) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new BannerHolder(inflater.inflate(R.layout.banner_layout, viewGroup, false));
            case 1:
                return new RxxpHolder(inflater.inflate(R.layout.rxxp_layout, viewGroup, false));
            case 2:
                return new MlssHolder(inflater.inflate(R.layout.mlss_layout, viewGroup, false));
            case 3:
                return new PzshHolder(inflater.inflate(R.layout.pash_layout, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                //轮播赋值
                ((BannerHolder) viewHolder).banner.setBannerData(banner.result);
                ((BannerHolder) viewHolder).banner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(((BannerBean.BannerItem) model).getXBannerUrl()).into((ImageView) view);
                    }
                });
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
    }

    @Override
    public int getItemCount() {
        if (banner != null && list != null) {
            return 4;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (position) {
            case 0:
                type = 0;
                break;
            case 1:
                type = 1;
                break;
            case 2:
                type = 2;
                break;
            case 3:
                type = 3;
                break;
        }
        return type;
    }
}
