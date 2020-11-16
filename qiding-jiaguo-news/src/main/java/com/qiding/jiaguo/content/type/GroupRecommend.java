package com.qiding.jiaguo.content.type;

import java.util.List;

import com.qiding.jiaguo.content.NewContent;
import com.qiding.jiaguo.news.PageNews;

import lombok.Data;

/**
 * @author <qiding@kuaishou.com>
 * Created on 2020-11-16
 */
@Data
public class GroupRecommend implements NewContent {
    private String icon;
    private String name;
    private List<NewContent> content;
}
