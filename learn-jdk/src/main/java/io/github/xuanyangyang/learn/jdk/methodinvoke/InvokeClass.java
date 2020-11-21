package io.github.xuanyangyang.learn.jdk.methodinvoke;

/**
 * @author xuanyangyang
 * @since 2020/11/21 17:24
 */
public class InvokeClass {

    public void printInfo() {
        System.out.println("i am InvokeClass");
    }

    public void doPrintInfo() {
        doSomething(this::printInfo);
    }

    public void doSomething(Runnable runnable) {

    }
}
