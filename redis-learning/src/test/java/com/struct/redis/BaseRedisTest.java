package com.struct.redis;

import org.junit.Assume;
import org.junit.Before;
import redis.clients.jedis.Jedis;

public abstract class BaseRedisTest {

    @Before
    public void beforeEach() {
        Assume.assumeTrue("Redis is not reachable. Start docker compose in redis-learning module.", RedisHealth.canConnect());
        try (Jedis jedis = JedisFactory.create()) {
            jedis.flushDB();
        }
    }
}
