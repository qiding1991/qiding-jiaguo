package com.qiding.jiaguo.content.type;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 广告带title
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdWithTitle implements NewContent {
    private String title;
    private String pic;
    private String subtitle;
}
