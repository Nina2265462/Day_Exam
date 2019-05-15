package com.bawei.day_exam.bean;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HomeList {
    public Result result;
    public String message;
    public String status;

    public static class Result {
        public Item rxxp;
        public Item pzsh;
        public Item mlss;
    }

    public static class Item {
        public List<Commodity> commodityList;
        public int id;
        public String name;
    }

    public static class Commodity {
        public int commodityId;
        public String commodityName;
        public String masterPic;
        public int price;
        public int saleNum;
    }
}
