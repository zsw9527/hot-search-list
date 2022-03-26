package org.zsw.crawler;

import org.zsw.entity.dto.HotWord;

import java.util.List;

/**
 * @author zsw
 */
public interface Crawler {

    /**
     * 抓取网页里的热搜关键词和跳转url
     * @return 热搜关键词和跳转url
     */
    List<HotWord> catchFromWeb();

}
