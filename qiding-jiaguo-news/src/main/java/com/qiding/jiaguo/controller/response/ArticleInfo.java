package com.qiding.jiaguo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleInfo {
    private String title;
    private String url;
    private String pic;
    private Long publishTime;
    private Integer readCount;
}
