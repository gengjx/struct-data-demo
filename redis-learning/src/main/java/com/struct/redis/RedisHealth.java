package com.struct.redis;

import redis.clients.jedis.Jedis;

public final class RedisHealth {
    private RedisHealth() {
    }

    public static boolean canConnect() {
        try (Jedis jedis = JedisFactory.create()) {
            String pong = jedis.ping();
            return "PONG".equalsIgnoreCase(pong);
        } catch (Exception e) {
            return false;
        }
    }
}
