package io.github.xuanyangyang.learn.jdk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuanyangyang
 * @since 2020/11/21 14:28
 */
public class ThreadLocalDemo {
    public static final AtomicInteger id = new AtomicInteger();
    public static final ThreadLocal<MyObj> MY_OBJ_THREAD_LOCAL = ThreadLocal.withInitial(() -> new MyObj(id.getAndIncrement()));

    public static void main(String[] args) {
        MyObj myObj = MY_OBJ_THREAD_LOCAL.get();
    }

    private static class MyObj {
        private final int id;

        private MyObj(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
