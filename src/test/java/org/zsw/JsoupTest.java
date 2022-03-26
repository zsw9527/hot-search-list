package org.zsw;


import org.junit.jupiter.api.Test;
import org.zsw.crawler.BaiduCrawler;
import org.zsw.crawler.Crawler;
import org.zsw.crawler.SinaCrawler;
import org.zsw.crawler.ToutiaoCrawler;

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
