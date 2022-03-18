package org.zsw.hot_search_list.crawler;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.zsw.hot_search_list.entity.dto.HotWord;
import java.util.ArrayList;
import java.util.List;

/**
 * 微博热搜爬虫
 * @author zsw
 */
@Slf4j
@Component
public class SinaCrawler implements Crawler {

    private final String URL = "https://s.weibo.com/top/summary";

    private final String WEIBO_PRE = "https://s.weibo.com";

    @Override
    public List<HotWord> catchFromWeb() {
        List<HotWord> resList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
                    .cookie("Cookie", "SINAGLOBAL=7604533115171.368.1639189947123; UOR=,,login.sina.com.cn; SCF=AhlibTi5lKPpyTLBeYJHvt6nRKIqqcGSasoUDuAcLLKCS4YM4dHoSuoVW7s1BUE5p4cxnM2sY16XLNaO8D70Qyo.; _s_tentry=login.sina.com.cn; Apache=472206035936.38.1642684364516; ULV=1642684364523:6:4:3:472206035936.38.1642684364516:1642428496028; SUB=_2AkMWtdDKdcPxrAZWm_ody2LmboVH-jylYLk8An7uJhMyAxgP7gY-qSVutBF-XBnMmoYIWhtLNZDrPOUaCbr1K3jT; SUBP=0033WrSXqPxfM72wWs9jqgMF55529P9D9Wh7re04yVl5_8JHhh.haWxf5JpVF02R1hz4SK2cehBR")
                    .get();

            Elements elements = doc.select(".td-02");

            for (Element element : elements) {
                String jumpUrl = element.select("a").attr("href");
                String hotWord = element.select("a").text();

                resList.add(new HotWord(hotWord, WEIBO_PRE + jumpUrl));
            }

            if (!CollectionUtils.isEmpty(resList)) {
                //第一个不是热搜词，是政治内容
                resList.remove(0);
            }

            return resList;
        } catch (Exception e) {
            log.error("sina catch error, targetWebUrl={}", URL, e);
        }
        return resList;
    }
}
