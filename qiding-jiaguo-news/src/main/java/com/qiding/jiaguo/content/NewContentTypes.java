package com.qiding.jiaguo.content;

public enum NewContentTypes {
    TEXT_AND_LINK(0,"文本+链接"),
    BIG_PIC_AND_TITLE(1,"大图+大标题"),
    PIC_AND_TITLE(2,"文本+图片"),
    AD_WITH_NO_TITLE(3,"广告：图片+链接+推广"),
    AD_WITH_TITLE(4,"广告：图片+title+推广"),
    SPECIAL_COLUMN_TEXT(5,"专栏,文本"),
    SPECIAL_COLUMN_VIDEO(6,"专栏，视频"),;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    NewContentTypes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
