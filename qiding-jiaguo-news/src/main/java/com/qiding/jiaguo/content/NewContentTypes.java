package com.qiding.jiaguo.content;

public enum NewContentTypes {
    TextAndLink(0,"文本+链接"),
    BigPicAndTitle(1,"大图+大标题"),
    PicAndTitle(2,"文本+图片"),
    AdWithNoTitle(3,"广告：图片+链接+推广"),
    AdWithTitle(4,"广告：图片+title+推广"),
    SpecialColumnText(5,"专栏,文本"),
    SpecialColumnVideo(6,"专栏，视频"),;

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
