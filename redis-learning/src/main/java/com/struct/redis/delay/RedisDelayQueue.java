package com.struct.redis.delay;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisDelayQueue {
    private final Jedis jedis;

    public RedisDelayQueue(Jedis jedis) {
        this.jedis = jedis;
    }

    public void offer(String queueKey, String payload, long executeAtMillis) {
        jedis.zadd(queueKey, executeAtMillis, payload);
    }

    public String poll(String queueKey, long nowMillis) {
        List<String> items = jedis.zrangeByScore(queueKey, 0, nowMillis, 0, 1);
        if (items.isEmpty()) {
            return null;
        }
        String payload = items.get(0);
        Long removed = jedis.zrem(queueKey, payload);
        return removed != null && removed > 0 ? payload : null;
    }
}
