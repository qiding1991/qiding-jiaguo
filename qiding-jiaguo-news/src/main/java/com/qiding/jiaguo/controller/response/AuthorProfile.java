package com.qiding.jiaguo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorProfile {
    private String avatar;
    private String title;
    private String subTitle;
    private Integer authorId;
    private Integer fanCount;
    private Integer readerCount;
    private Integer articleCount=100;
    private Integer followCount=200;

    public AuthorProfile(String avatar, String title, String subTitle, Integer authorId, Integer fanCount, Integer readerCount) {
        this.avatar = avatar;
        this.title = title;
        this.subTitle = subTitle;
        this.authorId = authorId;
        this.fanCount = fanCount;
        this.readerCount = readerCount;
    }
}
