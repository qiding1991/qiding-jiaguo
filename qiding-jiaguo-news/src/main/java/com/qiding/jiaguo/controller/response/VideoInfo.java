package com.qiding.jiaguo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoInfo {
    private Long id;
    private String title;
    private String url;
    private String pic;
    private String video;
    private Long publishTime;
    private Integer readCount;
    private Integer likeCount;
}
