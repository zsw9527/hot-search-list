package org.zsw.hot_search_list.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(new Date());
    }

}
