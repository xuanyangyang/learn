package io.github.xuanyangyang.learn.jdk.classload;

/**
 * @author xuanyangyang
 * @since 2020/11/21 16:46
 */
public class ConstantClass {
    public static final int value = 10;

    static {
        System.out.println("static init ConstantClass");
    }
}
