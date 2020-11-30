package com.wish.common.core.utils.ip;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: wz-blog
 * @description:
 * @author: Ylover
 * @created: 2020/11/30 14:53
 */
public class IpUtils {

    private final static String[] POSSIBLE_HEADERS = new String[] {
            "X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP",
            "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"
    };


    public static String getIpAddr(HttpServletRequest request){
        String ip = null;
        for (String header :
                POSSIBLE_HEADERS) {
            ip = request.getHeader(header);
            if (isNotBlank(ip) && "unknown".equalsIgnoreCase(ip)){
                return ip.contains(",") ? ip.split(",")[0] : ip;
            }
        }
        if (isNotBlank(ip) && "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    private static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    private static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
