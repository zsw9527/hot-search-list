package org.zsw.hot_search_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsw.hot_search_list.crawler.BaiduCrawler;
import org.zsw.hot_search_list.crawler.SinaCrawler;
import org.zsw.hot_search_list.crawler.ToutiaoCrawler;
import org.zsw.hot_search_list.entity.dto.HotWord;
import java.util.List;

/**
 * 热搜爬虫http接口
 */
@RestController
@RequestMapping("/hotSearch")
public class HotSearchCrawlerController {

    @Autowired
    private SinaCrawler sinaCrawler;

    @Autowired
    private BaiduCrawler baiduCrawler;

    @Autowired
    private ToutiaoCrawler toutiaoCrawler;

    @GetMapping("/sina")
    public List<HotWord> sinaCatch() {
        return sinaCrawler.catchFromWeb();
    }

    @GetMapping("/baidu")
    public List<HotWord> baiduCatch() {
        return baiduCrawler.catchFromWeb();
    }

    @GetMapping("/toutiao")
    public List<HotWord> toutiaoCatch() {
        return toutiaoCrawler.catchFromWeb();
    }

}
