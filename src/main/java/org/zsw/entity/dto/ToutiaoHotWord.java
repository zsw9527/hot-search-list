package org.zsw.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zsw
 */
@Data
@NoArgsConstructor
public class ToutiaoHotWord {

    @JSONField(name = "Title")
    private String title;

    @JSONField(name = "Url")
    private String url;

}
