package io.github.xuanyangyang.learn.jdk.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuanyangyang
 * @since 2020/11/22 00:35
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }

        }, "线程1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }

        }, "线程2").start();
    }
}
