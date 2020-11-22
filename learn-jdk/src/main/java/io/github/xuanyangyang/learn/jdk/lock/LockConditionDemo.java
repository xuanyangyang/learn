package io.github.xuanyangyang.learn.jdk.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuanyangyang
 * @since 2020/11/22 12:56
 */
public class LockConditionDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Queue<Object> queue = new LinkedList<>();

        new Thread(() -> product(lock, condition, queue), "生产者1").start();

        new Thread(() -> product(lock, condition, queue), "生产者2").start();

        new Thread(() -> consume(lock, condition, queue), "消费者1").start();
    }

    public static void product(Lock lock, Condition condition, Queue<Object> queue) {
        String threadName = Thread.currentThread().getName();
        lock.lock();
        try {
            while (true) {
                while (!queue.isEmpty()) {
                    condition.await();
                    System.out.println(threadName + "被唤醒");
                }
                Object obj = new Object();
                queue.add(obj);
                System.out.println(threadName + "生产一个" + obj);
                condition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void consume(Lock lock, Condition condition, Queue<Object> queue) {
        String threadName = Thread.currentThread().getName();
        lock.lock();
        try {
            while (true) {
                while (queue.isEmpty()) {
                    condition.await();
                    System.out.println(threadName + "被唤醒");
                }
                Object obj = queue.poll();
                System.out.println(threadName + "消费一个" + obj);
                condition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
