package org.zsw.hot_search_list.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ToutiaoApiRes {
    List<ToutiaoHotWord> data;
}
