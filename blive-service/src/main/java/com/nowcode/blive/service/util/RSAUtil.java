package com.nowcode.blive.service.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;

import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Title: RSAUtil
 * @Package: com.nowcode.blive.service.util
 * @description: RSA工具类
 * @author: Stackingrule
 * @created: 2022/02/24 21:52
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class RSAUtil {

    public static String PRIVATE_KEY = "MIIEv***XFu4=";

    public static String PUBLIC_KEY = "MIIB***DAQAB";

    public static String getPublicKeyStr() {
        return PUBLIC_KEY;
    }

    public static RSAPublicKey getPublicKey() throws Exception {
        byte[] decoded = Base64.decodeBase64(PUBLIC_KEY);
        return (RSAPublicKey) KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
    }

    public static RSAPrivateKey getPrivateKey() throws Exception {
        byte[] decoded = Base64.decodeBase64(PUBLIC_KEY);
        return (RSAPrivateKey) KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
    }

//    public static RSAKey generateKeyPair() throws NoSuchAlgorithmException {
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        keyPairGenerator.initialize(1024, new SecureRandom());
//        KeyPair keyPair = keyPairGenerator.generateKeyPair();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
//        String privateKeyString = new String(Base64.encodeBase64(privateKey.getEncoded()));
//        return new RSAKey(privateKey, privateKeyString, publicKey, publicKeyString);
//    }

    public static String encrypt(String source) throws Exception {
        byte[] decoded = Base64.decodeBase64(PUBLIC_KEY);
        RSAPublicKey rsaPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, rsaPublicKey);
        return Base64.encodeBase64String(cipher.doFinal(source.getBytes(StandardCharsets.UTF_8)));
    }

    public static Cipher getCipher() throws Exception {
        byte[] decoded = Base64.decodeBase64(PUBLIC_KEY);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, rsaPrivateKey);
        return cipher;
    }
}
