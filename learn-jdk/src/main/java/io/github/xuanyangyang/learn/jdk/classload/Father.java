package io.github.xuanyangyang.learn.jdk.classload;

/**
 * @author xuanyangyang
 * @since 2020/11/21 16:42
 */
public class Father {
    public static int value = 1;

    static {
        System.out.println("static init father");
    }

    {
        System.out.println("init father");
    }

    public void info() {
        System.out.println("i am parent");
    }
}
