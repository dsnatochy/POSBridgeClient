package com.poynt.posbridgeclient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by dennis on 3/7/17.
 */
public class Util {
    public static String generateHmacSHA256Signature(String data, String key)
            throws GeneralSecurityException {
        if (data == null || key == null)
            throw new IllegalArgumentException("key and/or data cannot be null");

        byte[] hmacData = null;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"),
                    "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");

            mac.init(secretKey);
            hmacData = mac.doFinal(data.getBytes("UTF-8"));
            return bytesToHex(hmacData);
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
