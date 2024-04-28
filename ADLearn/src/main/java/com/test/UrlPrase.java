package com.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * ClassName: UrlPrase
 * Package: com.test
 * Description:
 *
 * @Author Joe
 * @Create 2024-04-28 13:41
 * @Version
 */
public class UrlPrase {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = URLDecoder.decode("Mozilla/5.0%20(Windows;%20U;%20Windows%20NT%205.1;%20n" +
                "b)%20AppleWebKit/522.11.3%20(KHTML,%20like%20Gecko)%20Version/3.0%20Safari/522.11.3", "UTF-8");
        System.out.println(str);
    }
}
