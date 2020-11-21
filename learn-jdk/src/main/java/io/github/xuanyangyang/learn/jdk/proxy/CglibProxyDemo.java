package io.github.xuanyangyang.learn.jdk.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xuanyangyang
 * @since 2020/11/21 15:51
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/xuanyangyang/MyCode/java/learn/proxy");

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(DefaultHelloService.class.getClassLoader());
        enhancer.setSuperclass(DefaultHelloService.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                methodProxy.invokeSuper(o, objects);
                System.out.println("after");
                return null;
            }
        });
        HelloService helloService = (HelloService) enhancer.create();
        helloService.hello("xyy");
    }
}
