package com.struct.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

import static org.junit.Assert.*;

public class RedisDataStructureTest extends BaseRedisTest {

    @Test
    public void string_counter_with_ttl() {
        try (Jedis jedis = JedisFactory.create()) {
            String key = "counter:api";
            long v1 = jedis.incr(key);
            jedis.pexpire(key, 5000);
            long v2 = jedis.incr(key);

            assertEquals(1L, v1);
            assertEquals(2L, v2);
            assertTrue(jedis.pttl(key) > 0);
        }
    }

    @Test
    public void hash_profile() {
        try (Jedis jedis = JedisFactory.create()) {
            String key = "user:1";
            jedis.hset(key, "name", "he");
            jedis.hset(key, "age", "18");

            assertEquals("he", jedis.hget(key, "name"));
            assertEquals("18", jedis.hget(key, "age"));
        }
    }

    @Test
    public void list_simple_queue() {
        try (Jedis jedis = JedisFactory.create()) {
            String key = "queue:job";
            jedis.lpush(key, "a");
            jedis.lpush(key, "b");

            String r1 = jedis.rpop(key);
            String r2 = jedis.rpop(key);

            assertEquals("a", r1);
            assertEquals("b", r2);
        }
    }

    @Test
    public void set_dedup() {
        try (Jedis jedis = JedisFactory.create()) {
            String key = "uv:2026-01-26";
            assertEquals(1L, (long) jedis.sadd(key, "u1"));
            assertEquals(0L, (long) jedis.sadd(key, "u1"));
            assertTrue(jedis.sismember(key, "u1"));
        }
    }

    @Test
    public void zset_ranking_topn() {
        try (Jedis jedis = JedisFactory.create()) {
            String key = "rank:game";
            jedis.zadd(key, 10, "p1");
            jedis.zadd(key, 30, "p3");
            jedis.zadd(key, 20, "p2");

            List<String> top2 = jedis.zrevrange(key, 0, 1);
            Long p2Rank = jedis.zrevrank(key, "p2");
            List<String> all = jedis.zrange(key, 0, -1);

            assertEquals(List.of("p3", "p2"), top2);
            assertEquals(Long.valueOf(1), p2Rank);
            assertEquals(3, all.size());
        }
    }
}
