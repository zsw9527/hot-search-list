package org.zsw.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zsw
 */
@Data
@NoArgsConstructor
public class ToutiaoApiRes {
    List<ToutiaoHotWord> data;
}
