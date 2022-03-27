package org.zsw.crawler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.zsw.entity.dto.HotWord;
import org.zsw.entity.dto.ToutiaoApiRes;
import org.zsw.entity.dto.ToutiaoHotWord;
import org.zsw.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 头条热搜爬虫
 * @author zsw
 */
@Component
@Slf4j
public class ToutiaoCrawler implements Crawler {

    private final static String URL = "https://www.toutiao.com/hot-event/hot-board/?origin=toutiao_pc&_signature=_02B4Z6wo00901M8LjpgAAIDBkEhhQfZ9hhDPL4oAAFImxnrlR3Fg-cMemo62C6hsNU9GSx62jd1tC8fl6zpGxvIdK7LGEyPMNvJ0r3nc-F3fCJ-PPusWm93CE0wH6FxpuxVcvSg-RdD-NJeG96";

    @Override
    public List<HotWord> catchFromWeb() {
        List<HotWord> resList = new ArrayList<>();
        try {
            Map<String, String> headers = new HashMap<>(16);
            headers.put("Cookie", "msToken=t4iTStyAneSuyGeco7-8E7rcO0eRWlylZwmYI-CrdcECzq0Ixd7rp9vibLAT7ej-j_5VZwnTMbHs8ligpFUdNiFfPbrrDlFEoVsRtWfIE8F5; __ac_signature=_02B4Z6wo00f01Zah5awAAIDAyeIKd9e9uNmWgeEAAARMeb; ttcid=71dd269b9e91423f838415f8cf468de717; tt_webid=7053700106629924359; csrftoken=adc6f4f9c5388afc72ccfa940ac96461; _tea_utm_cache_24=undefined; tt_webid=7053700106629924359; tt_scid=vQFXo83wcDoeTQvJ-whRlTKR0j.iUjMrdIM8UzR01xjM6gCOZgrmiTfvFlAK04Yic582; s_v_web_id=verify_kyipqh7u_8PKbipSX_um8u_4RDH_9uri_wUFbX1kZNdgS; ttwid=1|pItRZ0zEl31k4DOTOuFkxx9-roHiSa_7tBbaHbAN_Fg|1642425505|101e1cab1abee7f39b13279c18444b08fa93a0865a1f5c40f62504bd6e9c07f9; MONITOR_WEB_ID=4a934751-f722-4437-9110-c4e55ce632c6");
            String res = HttpUtil.get(URL, headers);

            ToutiaoApiRes apiRes = JSON.parseObject(res, ToutiaoApiRes.class);
            if (apiRes == null) {
                return new ArrayList<>(0);
            }
            List<ToutiaoHotWord> hotWords = apiRes.getData();
            for (ToutiaoHotWord hotWord : hotWords) {
                resList.add(new HotWord(hotWord.getTitle(), hotWord.getUrl()));
            }
        } catch (Exception e) {
            log.error("toutiao catch error, targetWebUrl={}", URL, e);
        }
        return resList;
    }

}
