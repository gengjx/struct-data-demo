package com.struct.redis;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public final class JedisFactory {
    private JedisFactory() {
    }

    public static Jedis create() {
        HostAndPort hostAndPort = new HostAndPort(RedisConfig.host(), RedisConfig.port());
        JedisClientConfig config = DefaultJedisClientConfig.builder()
                .password(RedisConfig.password())
                .connectionTimeoutMillis(2000)
                .socketTimeoutMillis(2000)
                .build();
        return new Jedis(hostAndPort, config);
    }
}
