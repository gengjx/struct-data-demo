package com.struct.redis.lock;

import java.util.Collections;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class RedisLock {
    private static final String UNLOCK_LUA = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    private final Jedis jedis;

    public RedisLock(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean tryLock(String key, String token, long ttlMillis) {
        SetParams params = SetParams.setParams().nx().px(ttlMillis);
        String ret = jedis.set(key, token, params);
        return "OK".equalsIgnoreCase(ret);
    }

    public boolean unlock(String key, String token) {
        Object ret = jedis.eval(UNLOCK_LUA, Collections.singletonList(key), Collections.singletonList(token));
        if (ret instanceof Long) {
            return ((Long) ret) == 1L;
        }
        return false;
    }
}
