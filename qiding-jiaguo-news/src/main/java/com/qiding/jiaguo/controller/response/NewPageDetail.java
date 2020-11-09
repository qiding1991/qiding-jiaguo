package com.qiding.jiaguo.controller.response;

import com.qiding.jiaguo.news.PageNews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewPageDetail {
    private List<PageNews> recommendNew;
    private List<PageNews> newsList;
    private boolean hasMore;
}
