package com.struct.redis;

import com.struct.redis.delay.RedisDelayQueue;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class DelayQueueTest extends BaseRedisTest {

    @Test
    public void delay_queue_poll_due_task() throws Exception {
        try (Jedis jedis = JedisFactory.create()) {
            RedisDelayQueue q = new RedisDelayQueue(jedis);
            String key = "dq:email";

            long now = System.currentTimeMillis();
            q.offer(key, "due", now - 1);
            q.offer(key, "future", now + 50);

            String p1 = q.poll(key, System.currentTimeMillis());
            assertEquals("due", p1);

            String p2 = q.poll(key, System.currentTimeMillis());
            assertNull(p2);

            Thread.sleep(60);
            String p3 = q.poll(key, System.currentTimeMillis());
            assertEquals("future", p3);
        }
    }
}
