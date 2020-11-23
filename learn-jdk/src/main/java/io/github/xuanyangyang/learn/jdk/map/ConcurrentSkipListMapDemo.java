package io.github.xuanyangyang.learn.jdk.map;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xuanyangyang
 * @since 2020/11/23 12:57
 */
public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 1000; i++) {
            Integer boxI = i;
            map.put(boxI, boxI);
        }
        Integer boxI = 300;
        Integer res = map.get(boxI);
        System.out.println(res);
    }
}
