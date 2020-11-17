package com.qiding.jiaguo.news;

import com.qiding.jiaguo.content.NewContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageNews {
    private Integer contentType;
    private NewContent content;
    private String url;
    private Long newId;
}
