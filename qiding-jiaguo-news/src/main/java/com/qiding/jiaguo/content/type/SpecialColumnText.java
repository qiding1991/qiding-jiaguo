package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 专栏 文本
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SpecialColumnText implements NewContent {
    private String pic;
    private String title;
    private String subTitle;
    private String author;
    private Long publishTime;
    private Integer readCount;
}
