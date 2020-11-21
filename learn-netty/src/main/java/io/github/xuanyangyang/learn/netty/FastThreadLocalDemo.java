package io.github.xuanyangyang.learn.netty;

import io.netty.util.concurrent.FastThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuanyangyang
 * @since 2020/11/21 14:55
 */
public class FastThreadLocalDemo {
    public static final AtomicInteger id = new AtomicInteger();
    public static final FastThreadLocal<MyObj> MY_OBJ_THREAD_LOCAL = new FastThreadLocal<MyObj>() {
        @Override
        protected MyObj initialValue() throws Exception {
            return new MyObj(id.getAndIncrement());
        }
    };

    public static void main(String[] args) {
        new Thread(() -> {
            MyObj myObj = MY_OBJ_THREAD_LOCAL.get();
            System.out.println(myObj.getId());
        }).start();

        new Thread(() -> {
            MyObj myObj = MY_OBJ_THREAD_LOCAL.get();
            System.out.println(myObj.getId());
        }).start();
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
