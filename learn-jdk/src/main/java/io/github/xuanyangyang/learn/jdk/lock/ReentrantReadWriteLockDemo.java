package io.github.xuanyangyang.learn.jdk.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xuanyangyang
 * @since 2020/11/22 01:01
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(() -> {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
            } finally {
                lock.writeLock().unlock();
            }
        }, "线程1").start();

        new Thread(() -> {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了写锁");
            } finally {
                lock.writeLock().unlock();
            }
        }, "线程2").start();

        new Thread(() -> {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
            } finally {
                lock.readLock().unlock();
            }
        }, "线程3").start();

        new Thread(() -> {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
            } finally {
                lock.readLock().unlock();
            }
        }, "线程4").start();

        new Thread(() -> {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了读锁");
            } finally {
                lock.readLock().unlock();
            }
        }, "线程5").start();
    }
}
