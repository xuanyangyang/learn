package io.github.xuanyangyang.learn.jdk.proxy;

/**
 * @author xuanyangyang
 * @since 2020/11/21 15:28
 */
public class DefaultHelloService implements HelloService {
    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
