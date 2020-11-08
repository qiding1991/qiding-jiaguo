package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小标题+图片
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicAndTitle implements NewContent {
    private String pic;
    private String title;
    private String subTitle;
    private Long publishTime;
    private Integer readCount;
}
