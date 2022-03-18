package org.zsw.hot_search_list;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.zsw.hot_search_list.crawler.BaiduCrawler;
import org.zsw.hot_search_list.crawler.Crawler;
import org.zsw.hot_search_list.crawler.SinaCrawler;
import org.zsw.hot_search_list.crawler.ToutiaoCrawler;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;

public class JsoupTest {

    @Test
    public void testWeibo() {
        Crawler crawler = new SinaCrawler();

        crawler.catchFromWeb();
    }

    @Test
    public void testBaidu() {
        Crawler crawler = new BaiduCrawler();

        crawler.catchFromWeb();
    }

    @Test
    public void testToutiao() {
        Crawler crawler = new ToutiaoCrawler();

        crawler.catchFromWeb();
    }

}
