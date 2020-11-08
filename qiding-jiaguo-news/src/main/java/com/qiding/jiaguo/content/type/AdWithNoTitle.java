package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 广告，没有title
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdWithNoTitle implements NewContent {
    private String pic;
    private String subtitle;
}
