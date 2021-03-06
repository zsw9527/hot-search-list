package org.zsw.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author zsw
 */
@Slf4j
public class HttpUtil {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    public static String get(String url, Map<String, String> headers) {
        Request.Builder build = new Request.Builder()
                .url(url)
                .get();

        //添加header
        if (!CollectionUtils.isEmpty(headers)) {
            for (String key : headers.keySet()) {
                build.header(key, headers.get(key));
            }
        }

        Request request = build.build();

        try {
            Response res = OK_HTTP_CLIENT.newCall(request).execute();
            if (res.isSuccessful()) {
                return res.body().string();
            }
        } catch (IOException e) {
            log.error("http exception", e);
        }
        return null;
    }

}
