package io.github.xuanyangyang.learn.redis.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * redisson 锁
 *
 * @author xuanyangyang
 * @since 2020/11/27 13:18
 */
public class RedissonLockDemo {
    public static void main(String[] args) {
        RedissonClient redissonClient = RedissonUtils.getRedissonClient();
        RLock lock = redissonClient.getLock("xyy");
        doLock("线程1", lock);
        doLock("线程2", lock);
    }

    public static void doLock(String threadName, RLock lock) {
        new Thread(() -> {
            lock.lock(1, TimeUnit.MINUTES);
            try {
                System.out.println(Thread.currentThread().getName() + "获得了锁");
            } finally {
                lock.unlock();
            }
        }, threadName).start();
    }
}
