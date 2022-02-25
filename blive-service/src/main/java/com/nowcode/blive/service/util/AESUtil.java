package com.nowcode.blive.service.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * @Title: AESUtil
 * @Package: com.nowcode.blive.service.util
 * @description: AES工具类
 * @author: Stackingrule
 * @created: 2022/02/24 11:21
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private final Cipher decryptCiper;
    private final Cipher encryptCiper;
    private final String seed;

    public AESUtil(String seed) throws Exception {
        this.seed = seed;
        decryptCiper = Cipher.getInstance(KEY_ALGORITHM);
        encryptCiper = Cipher.getInstance(KEY_ALGORITHM);
        decryptCiper.init(Cipher.DECRYPT_MODE, this.getSecretKey());
        encryptCiper.init(Cipher.ENCRYPT_MODE, this.getSecretKey());
    }

    public String decrypt(String content) throws Exception {
        byte[] bytes = Base64.decodeBase64(content);
        byte[] result = decryptCiper.doFinal(bytes);
        return new String(result, StandardCharsets.UTF_8);
    }

    public SecretKey getSecretKey() throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(seed.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(128, random);
        return kg.generateKey();
    }

}
