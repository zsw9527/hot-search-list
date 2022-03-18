package org.zsw.hot_search_list.crawler;

import org.zsw.hot_search_list.entity.dto.HotWord;

import java.util.List;

public interface Crawler {

    List<HotWord> catchFromWeb();

}
