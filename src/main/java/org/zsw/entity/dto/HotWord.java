package org.zsw.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 热词
 * @author zsw
 */
@Data
@AllArgsConstructor
public class HotWord {

    /**
     * 热搜关键词
     */
    private String word;

    /**
     * 点击关键词后跳转到的页面地址
     */
    private String url;

    public HotWord() {}

}
