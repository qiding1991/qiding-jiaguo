package com.qiding.jiaguo.controller.response;

import com.qiding.jiaguo.news.PageNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavouriteInfo {
    private Long  favouriteId;
    private PageNews newInfo;
}
