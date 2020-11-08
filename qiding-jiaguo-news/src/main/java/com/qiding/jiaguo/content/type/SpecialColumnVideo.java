package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.Data;

/**
 * 专栏视频
 */
@Data
public class SpecialColumnVideo implements NewContent {
    private String pic;
    private String title;
    private String subTitle;
    private String author;
    private Long publishTime;
    private Integer commentCounts;
    private Integer thumbUpCounts;
}
