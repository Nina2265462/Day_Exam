package com.bawei.day_exam.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class BannerBean {
    public String message;
    public String status;
    public List<BannerItem> result;

    public static class BannerItem extends SimpleBannerInfo {
        public String imageUrl;
        public String jumpUrl;
        public int rank;
        public String title;

        public String getXBannerUrl() {
            return imageUrl;
        }
    }
}
