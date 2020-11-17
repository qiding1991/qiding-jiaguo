package com.qiding.jiaguo.controller;

import com.google.common.collect.ImmutableMap;
import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.content.NewContent;
import com.qiding.jiaguo.content.NewContentTypes;
import com.qiding.jiaguo.content.type.PicAndTitle;
import com.qiding.jiaguo.controller.response.FavouriteInfo;
import com.qiding.jiaguo.news.PageNews;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "收藏 列表，删除")
@RestController
public class FavouriteController extends BaseController {

    @GetMapping("favourite/list")
    public CommonResponse favouriteList(@RequestHeader("userId") String userId,
                                        @RequestParam("offset") Integer offset,
                                        @RequestParam("limit") Integer limit) {


        List<FavouriteInfo> favouriteInfoList = new ArrayList<>();
        NewContent bigPicAndTitle = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片的")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();

        PageNews pageNews = PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.PIC_AND_TITLE.getCode())
                .content(bigPicAndTitle)
                .newId(2L).build();

        FavouriteInfo favouriteInfo=new FavouriteInfo(1L,pageNews);
        favouriteInfoList.add(favouriteInfo);


        NewContent bigPicAndTitle2 = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片的")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();


        PageNews pageNews2 = PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.PIC_AND_TITLE.getCode())
                .content(bigPicAndTitle2)
                .newId(2L).build();


        FavouriteInfo favouriteInfo2=new FavouriteInfo(2L,pageNews2);
        favouriteInfoList.add(favouriteInfo2);

        return CommonResponse.success(ImmutableMap.of("hasMore", true, "infoList", favouriteInfoList));
    }


    @PostMapping("favourite/del")
    public CommonResponse favouriteList(@RequestHeader("userId") String userId,@RequestBody List<Long> ids){
        return CommonResponse.success();
    }
}
