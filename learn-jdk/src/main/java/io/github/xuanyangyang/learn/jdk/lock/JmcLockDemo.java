package io.github.xuanyangyang.learn.jdk.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个用于jmc查看锁竞争
 *
 * @author xuanyangyang
 * @since 2020/11/15 15:41
 */
public class JmcLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> lockTest2(lock), "测试1").start();
        new Thread(() -> lockTest2(lock), "测试2").start();
        new Thread(() -> lockTest2(lock), "测试3").start();
    }

    public static void lockTest2(Object obj) {
        while (true) {
            synchronized (obj) {
                int c = 0;
                for (int i = 0; i < 10000; i++) {
                    c++;
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void lockTest(Lock lock) {
        while (true) {
            lock.lock();
            try {

                int c = 0;
                for (int i = 0; i < 10000; i++) {
                    c++;
                }
                System.out.println(Thread.currentThread().getName());
//                if (Thread.currentThread().getName().equals("测试1")) {
//                    try {
//                        Thread.sleep(10 * 1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            } finally {
                lock.unlock();
            }
        }
    }
}
