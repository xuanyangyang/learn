package io.github.xuanyangyang.learn.jdk.map;

import java.util.LinkedHashMap;

/**
 * @author xuanyangyang
 * @since 2020/11/20 17:42
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < 12; i++) {
//            map.put(i + 1, i + 1);
//        }
        for (int i = 12; i > 0; i--) {
            map.put(i, i);
        }
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("==============================================");
        map.put(1, 2);
        map.put(2, 1);
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
