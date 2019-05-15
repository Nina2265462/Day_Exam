package com.bawei.day_exam.holder.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.day_exam.R;
import com.stx.xhb.xbanner.XBanner;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class BannerHolder extends RecyclerView.ViewHolder {


   public XBanner banner;

    public BannerHolder(@NonNull View itemView) {
        super(itemView);
        banner = itemView.findViewById(R.id.xbanner);
    }
}
