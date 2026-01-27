package com.struct.redis;

import com.struct.redis.ratelimit.FixedWindowRateLimiter;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class RateLimiterLuaTest extends BaseRedisTest {

    @Test
    public void fixed_window_rate_limit() {
        try (Jedis jedis = JedisFactory.create()) {
            FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(jedis);
            String key = "rl:api:demo";

            assertTrue(limiter.allow(key, 3, 1000));
            assertTrue(limiter.allow(key, 3, 1000));
            assertTrue(limiter.allow(key, 3, 1000));
            assertFalse(limiter.allow(key, 3, 1000));
        }
    }
}
