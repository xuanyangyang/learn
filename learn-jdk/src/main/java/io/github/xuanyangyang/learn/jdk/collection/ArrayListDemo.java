package io.github.xuanyangyang.learn.jdk.collection;

import java.util.ArrayList;

/**
 * @author xuanyangyang
 * @since 2020/11/20 13:23
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i+1);
        }
        list.add(10);
        list.add(11);
    }
}
