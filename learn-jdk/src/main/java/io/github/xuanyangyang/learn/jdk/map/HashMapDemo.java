package io.github.xuanyangyang.learn.jdk.map;

import java.util.HashMap;

/**
 * @author xuanyangyang
 * @since 2020/11/20 16:21
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(i + 1, i + 1);
        }
        map.put(13, 13);
    }
}
