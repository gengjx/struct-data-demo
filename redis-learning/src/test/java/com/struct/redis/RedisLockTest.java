package com.struct.redis;

import com.struct.redis.lock.RedisLock;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class RedisLockTest extends BaseRedisTest {

    @Test
    public void lock_and_unlock_by_token() {
        String key = "lock:order:1";

        try (Jedis j1 = JedisFactory.create(); Jedis j2 = JedisFactory.create()) {
            RedisLock lock1 = new RedisLock(j1);
            RedisLock lock2 = new RedisLock(j2);

            boolean ok1 = lock1.tryLock(key, "t1", 3000);
            boolean ok2 = lock2.tryLock(key, "t2", 3000);

            assertTrue(ok1);
            assertFalse(ok2);

            assertFalse(lock2.unlock(key, "t2"));
            assertTrue(lock1.unlock(key, "t1"));

            boolean ok3 = lock2.tryLock(key, "t2", 3000);
            assertTrue(ok3);
        }
    }
}
