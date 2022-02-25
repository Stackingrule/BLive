package com.nowcode.blive.service.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @Title: MD5Util
 * @Package: com.nowcode.blive.service.util
 * @description: MD5工具类
 * @author: Stackingrule
 * @created: 2022/02/24 10:59
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class MD5Util {

    public static String sign(String content, String salt, String charset) throws UnsupportedEncodingException {
        content = content + salt;
        return DigestUtils.md5Hex(getContentBytes(content, charset));
    }

    public static boolean verity(String content, String sign, String salt, String charset) throws UnsupportedEncodingException {
        content = content + salt;
        String mysign = DigestUtils.md5Hex(getContentBytes(content, charset));
        return mysign.equals(sign);
    }

    private static byte[] getContentBytes(String content, String charset) throws UnsupportedEncodingException {
        if (!"".equals(charset)) {
            try {
                return content.getBytes(charset);
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException("MD5签名过程出现错误，指定的编码集错误!");
            }
        } else {
            return content.getBytes(charset);
        }
    }
}
