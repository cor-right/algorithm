package _2025.subjects._6_hashmap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

/**
 * TinyUrl 的加密和解密
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/encode-and-decode-tinyurl/"/>
 */
public class _535_encode_and_decode_tiny_url {

    // Encodes a URL to a shortened URL.
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    private Map<String, String> dataBase = new HashMap<>();

    /**
     *
     * @param longUrl
     * @return
     */
    public String encode(String longUrl) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        Supplier<String> supplier = () -> format.format(new Date()) + "000" + new Random().ints(1000000, 9999999).toString();

        String shortUrl = supplier.get();
        while (dataBase.containsKey(shortUrl)) {
            shortUrl = supplier.get();
        }

        dataBase.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dataBase.get(shortUrl);
    }

}