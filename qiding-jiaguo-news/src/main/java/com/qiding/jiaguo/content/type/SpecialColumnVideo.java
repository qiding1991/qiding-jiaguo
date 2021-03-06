package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 专栏视频
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecialColumnVideo implements NewContent {
    private String pic;
    private String videoUrl;
    private String title;
    private String subTitle;
    private String author;
    private Long publishTime;
    private Integer commentCounts;
    private Integer thumbUpCounts;
}
