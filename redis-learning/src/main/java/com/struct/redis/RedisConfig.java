package com.struct.redis;

public final class RedisConfig {
    private RedisConfig() {
    }

    public static String host() {
        String v = System.getenv("REDIS_HOST");
        return v == null || v.isBlank() ? "127.0.0.1" : v;
    }

    public static int port() {
        String v = System.getenv("REDIS_PORT");
        if (v == null || v.isBlank()) {
            return 6379;
        }
        return Integer.parseInt(v);
    }

    public static String password() {
        String v = System.getenv("REDIS_PASSWORD");
        return v == null || v.isBlank() ? "redis123" : v;
    }
}
