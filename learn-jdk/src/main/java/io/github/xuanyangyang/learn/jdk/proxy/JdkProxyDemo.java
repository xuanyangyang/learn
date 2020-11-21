package io.github.xuanyangyang.learn.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuanyangyang
 * @since 2020/11/21 15:23
 */
public class JdkProxyDemo {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloService helloService = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), DefaultHelloService.class.getInterfaces(), new InvocationHandler() {
            private Object target = new DefaultHelloService();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("调用之前");
                return method.invoke(target, args);
            }
        });

        helloService.hello("xyy");
    }
}
