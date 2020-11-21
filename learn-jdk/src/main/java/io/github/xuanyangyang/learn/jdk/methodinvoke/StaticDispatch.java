package io.github.xuanyangyang.learn.jdk.methodinvoke;

/**
 * @author xuanyangyang
 * @since 2020/11/21 17:37
 */
public class StaticDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man man) {
        System.out.println("hello,man!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello,woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);

        man.sayHello();
        woman.sayHello();
    }
}
