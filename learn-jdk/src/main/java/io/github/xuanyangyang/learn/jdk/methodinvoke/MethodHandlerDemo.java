package io.github.xuanyangyang.learn.jdk.methodinvoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author xuanyangyang
 * @since 2020/11/21 18:09
 */
public class MethodHandlerDemo {
    static class MyPrint {
        public void println(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) throws Throwable {
        getPrintMethodHandle(new MyPrint()).invokeExact("xyy");
    }

    private static MethodHandle getPrintMethodHandle(Object obj) throws NoSuchMethodException, IllegalAccessException {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和 具体参数（methodType()第二个及以后的参数）。
        MethodType methodType = MethodType.methodType(void.class, String.class);
        // lookup()方法来自于MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法 名称、方法类型，并且符合调用权限的方法句柄。
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接 收者，也即this指向的对象，这个参数以前是放在参数列表中进行传递，现在提供了bindTo() 方法来完成这件事情。
        return lookup().findVirtual(obj.getClass(), "println", methodType).bindTo(obj);
    }

}
