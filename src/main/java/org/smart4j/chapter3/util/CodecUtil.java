package org.smart4j.chapter3.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by wangbin10 on 2018/8/20.
 * 编码与解码操作工具类
 */
public class CodecUtil {
    /**
     * URL编码
     */
    public static String encodeURL(String source) {
        String target = null;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * URL解码
     */
    public static String decodeURL(String source) {
        String target = null;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return target;
    }
}
