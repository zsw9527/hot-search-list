package org.zsw.crawler;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.zsw.entity.dto.HotWord;

import java.util.ArrayList;
import java.util.List;

/**
 * 百度热搜爬虫
 * @author zsw
 */
@Slf4j
@Component
public class BaiduCrawler implements Crawler {

    private final static String URL = "https://top.baidu.com/board?tab=realtime";

    @Override
    public List<HotWord> catchFromWeb() {
        List<HotWord> resList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
                    .cookie("Cookie", "BIDUPSID=2263B7D9D4FBCD74ACE7EE3221EE8B1E; PSTM=1637406652; BAIDUID=2263B7D9D4FBCD7407F0BE5527FF2724:FG=1; __yjs_duid=1_d0c50c927d9551fe8b306c28bf28e54d1637413675147; BDUSS=lOUXlaT3NzaWN0ZzI2cm1oMFhuUTlxNFNSYmVSSFc0dkswR1BxcmJJVWMzTk5oRVFBQUFBJCQAAAAAAAAAAAEAAACfXQmjx6axyrutenN3AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABxPrGEcT6xhaX; BDUSS_BFESS=lOUXlaT3NzaWN0ZzI2cm1oMFhuUTlxNFNSYmVSSFc0dkswR1BxcmJJVWMzTk5oRVFBQUFBJCQAAAAAAAAAAAEAAACfXQmjx6axyrutenN3AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABxPrGEcT6xhaX; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; delPer=0; PSINO=1; ZD_ENTRY=empty; BAIDUID_BFESS=21BA39738BE3D2DB3F0BA74C2E321DA5:FG=1; BDRCVFR[sErxx2-54-m]=9xWipS8B-FspA7EnHc1QhPEUf; H_PS_PSSID=35740_35105_35735_35488_35456_34584_35490_35699_35246_34812_35666_35315_26350_35746; BA_HECTOR=a00405212lag010hv41gu7gfi0q")
                    .get();

            Elements elements = doc.select(".content_1YWBm");

            for (Element element : elements) {
                String jumpUrl = element.select("a").attr("href");
                String hotWord = element.select(".c-single-text-ellipsis").text();

                resList.add(new HotWord(hotWord, jumpUrl));
            }

            return resList;
        } catch (Exception e) {
            log.error("baidu catch error, targetWebUrl={}", URL, e);
        }
        return resList;
    }
}
