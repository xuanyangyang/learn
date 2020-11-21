package io.github.xuanyangyang.learn.jdk.methodinvoke;

/**
 * @author xuanyangyang
 * @since 2020/11/21 17:21
 */
public class MethodInvokeDemo {
    public static void main(String[] args) {
        sayHello();
        InvokeClass invokeClass = new InvokeClass();
        invokeClass.printInfo();
        doSomething(invokeClass::printInfo);
        doSomething(() -> System.out.println("i am lambda"));
        doSomething(MethodInvokeDemo::sayHello);
    }

    public static void sayHello() {
        System.out.println("hello");
    }

    public static void doSomething(Runnable runnable) {
        runnable.run();
    }
}
