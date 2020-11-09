package com.qiding.jiaguo.news;

public enum NewType {
    RECOMMEND_NEW(4,"推荐"),
    AD_NEW(3, "广告"),
    SPECIAL_COLUMN(2, "专栏"),
    INT_NEWS(1, "国际信息");
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    NewType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}

