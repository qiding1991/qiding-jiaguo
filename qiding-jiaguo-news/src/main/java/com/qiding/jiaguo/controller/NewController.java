package com.qiding.jiaguo.controller;


import com.qiding.jiaguo.content.NewContent;
import com.qiding.jiaguo.content.NewContentTypes;
import com.qiding.jiaguo.news.NewType;
import com.qiding.jiaguo.news.PageNews;
import com.qiding.jiaguo.constant.CommonResponse;
import com.qiding.jiaguo.content.type.*;
import com.qiding.jiaguo.controller.response.NewPageDetail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "热门,国际信息，地区新闻")
@RestController
public class NewController extends BaseController {

    @GetMapping("new/hot")
    public CommonResponse<NewPageDetail> hotNew(@RequestParam(value = "size") Integer size,
                                                @RequestParam(value = "offset") Integer offset) {

        NewPageDetail pageDetail = new NewPageDetail();
        List<PageNews> recommendNew = new ArrayList<>();
        //推荐
        PageNews pageNews = PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.TextAndLink.getCode())
                .content(new TextAndLink("头条的-发大水了"))
                .build();
        recommendNew.add(pageNews);
        PageNews pageNews2 = PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.TextAndLink.getCode())
                .content(new TextAndLink("头条的-发大水了"))
                .build();

        recommendNew.add(pageNews2);


        List<PageNews> newsList = new ArrayList<>();

        //大图片 布局
        PicAndTitle bigPicAndTitle = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.BigPicAndTitle.getCode())
                .content(bigPicAndTitle)
                .newType(NewType.int_news.getCode())
                .newId(11111L)
                .build());

        //正常布局
        bigPicAndTitle = PicAndTitle.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .title("大图片的")
                .publishTime(Instant.now().toEpochMilli())
                .subTitle("国际新闻")
                .readCount(10)
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.PicAndTitle.getCode())
                .content(bigPicAndTitle)
                .newId(2222L)
                .newType(NewType.int_news.getCode())
                .build());


        //广告布局
        NewContent adWithNoTitle = AdWithNoTitle.builder()
                .subtitle("推广")
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .build();
        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.AdWithNoTitle.getCode())
                .content(adWithNoTitle)
                .build());

        //广告
        NewContent adWithTitle = AdWithTitle.builder()
                .subtitle("推广")
                .title("xxxxxxxxxxxxxxx")
                .build();

        newsList.add(PageNews.builder()
                .url("http://www.baidu.com")
                .contentType(NewContentTypes.AdWithTitle.getCode())
                .content(adWithTitle)
                .build());

        //专栏-文档
        NewContent specialColumnText = SpecialColumnText.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .author("齐定")
                .subTitle("专栏")
                .publishTime(Instant.now().toEpochMilli())
                .readCount(100)
                .build();

        newsList.add(
                PageNews.builder()
                        .url("http://www.baidu.com")
                        .contentType(NewContentTypes.SpecialColumnText.getCode())
                        .content(specialColumnText)
                        .newType(NewType.Special_Column.getCode())
                        .newId(333L)
                        .build());

        //专栏视频
        NewContent specialColumnVideo = SpecialColumnVideo.builder()
                .pic("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2551094610,271931118&fm=26&gp=0.jpg")
                .author("齐定")
                .subTitle("专栏")
                .title("视频dadadad")
                .commentCounts(1111)
                .publishTime(Instant.now().toEpochMilli())
                .thumbUpCounts(222222)
                .videoUrl("http://dddadadadadad")
                .build();

        newsList.add(
                PageNews.builder()
                        .url("http://www.baidu.com")
                        .contentType(NewContentTypes.SpecialColumnText.getCode())
                        .content(specialColumnVideo)
                        .newType(NewType.Special_Column.getCode())
                        .newId(333L)
                        .build());


        pageDetail.setHasMore(Boolean.TRUE);
        pageDetail.setNewsList(newsList);
        pageDetail.setRecommendNew(recommendNew);
        return success(pageDetail);

    }

    @GetMapping("new/area")
    public CommonResponse<NewPageDetail> areaNew(@RequestParam(value = "area") String areaType,
                                                 @RequestParam(value = "size") Integer size,
                                                 @RequestParam(value = "offset") Integer offset) {

        return hotNew(size, offset);
    }


}
