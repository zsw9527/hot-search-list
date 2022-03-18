package org.zsw.hot_search_list.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToutiaoHotWord {

    @JSONField(name = "Title")
    private String title;

    @JSONField(name = "Url")
    private String url;

}
