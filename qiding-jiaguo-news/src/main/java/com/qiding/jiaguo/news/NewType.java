package com.qiding.jiaguo.news;

public enum NewType {

    Special_Column(2, "专栏"),
    int_news(1, "国际信息");
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

