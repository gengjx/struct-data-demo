package com.struct.redis.ratelimit;

import java.util.Arrays;
import java.util.Collections;

import redis.clients.jedis.Jedis;

public class FixedWindowRateLimiter {
    private static final String LUA = "local c = redis.call('incr', KEYS[1]); if c == 1 then redis.call('pexpire', KEYS[1], ARGV[2]); end; if c <= tonumber(ARGV[1]) then return 1 else return 0 end";

    private final Jedis jedis;

    public FixedWindowRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean allow(String key, long limit, long windowMillis) {
        Object ret = jedis.eval(LUA, Collections.singletonList(key), Arrays.asList(String.valueOf(limit), String.valueOf(windowMillis)));
        return (ret instanceof Long) && ((Long) ret) == 1L;
    }
}
