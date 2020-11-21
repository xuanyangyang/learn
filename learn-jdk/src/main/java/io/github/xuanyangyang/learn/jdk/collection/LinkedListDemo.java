package io.github.xuanyangyang.learn.jdk.collection;

import java.util.LinkedList;

/**
 * @author xuanyangyang
 * @since 2020/11/20 13:56
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        list.add(-1);
        System.out.println(list.size());
    }
}
