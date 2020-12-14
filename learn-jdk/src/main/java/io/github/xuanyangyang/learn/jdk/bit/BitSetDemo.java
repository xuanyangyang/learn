package io.github.xuanyangyang.learn.jdk.bit;

import java.util.BitSet;

/**
 * @author xuanyangyang
 * @since 2020/12/14 11:31
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        int x = Integer.MAX_VALUE;
        System.out.println(bitSet.get(x));
        bitSet.set(x);
        System.out.println(bitSet.get(x));
    }
}
