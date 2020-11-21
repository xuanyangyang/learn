package io.github.xuanyangyang.learn.jdk.classload;

/**
 * @author xuanyangyang
 * @since 2020/11/21 16:43
 */
public class Son extends Father {
    static {
        System.out.println("static init son");
    }

    {
        System.out.println("init son");
    }

    @Override
    public void info() {
        System.out.println("i am son");
    }
}
