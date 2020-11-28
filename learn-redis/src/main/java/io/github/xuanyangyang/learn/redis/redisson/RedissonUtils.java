package io.github.xuanyangyang.learn.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author xuanyangyang
 * @since 2020/11/27 13:21
 */
public class RedissonUtils {
    private volatile static RedissonClient redissonClient;

    public static RedissonClient getRedissonClient() {
        if (redissonClient == null) {
            synchronized (RedissonUtils.class) {
                if (redissonClient == null) {
                    redissonClient = newRedissonClient();
                }
            }
        }
        return redissonClient;
    }

    private static RedissonClient newRedissonClient() {
        try {
            URL resource = RedissonUtils.class.getClassLoader().getResource("redis.yml");
            Config config = Config.fromYAML(resource);
            return Redisson.create(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
