package io.github.xuanyangyang.learn.jdk.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuanyangyang
 * @since 2020/11/20 20:20
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 11; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        // 触发扩容
        map.put("12", "12");
        for (int i = 13; i <= 23; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        new Thread(() -> {
            // 触发扩容
            map.put("24", "24");
        }).start();

        new Thread(() -> {
            // 触发扩容
            map.put("25", "25");
        }).start();
    }
}
