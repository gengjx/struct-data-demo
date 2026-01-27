package com.struct.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CacheAsideTest extends BaseRedisTest {

    static class FakeDb {
        private final Map<String, String> data = new HashMap<>();
        private int readCount;

        String get(String id) {
            readCount++;
            return data.get(id);
        }

        void put(String id, String v) {
            data.put(id, v);
        }

        int readCount() {
            return readCount;
        }
    }

    @Test
    public void cache_aside_read_write() {
        FakeDb db = new FakeDb();
        db.put("1", "v1");

        try (Jedis jedis = JedisFactory.create()) {
            String cacheKey = "cache:item:1";

            // read 1: miss -> db -> set cache
            String v1 = readThrough(jedis, db, cacheKey, "1");
            assertEquals("v1", v1);
            assertEquals(1, db.readCount());

            // read 2: hit -> no db
            String v2 = readThrough(jedis, db, cacheKey, "1");
            assertEquals("v1", v2);
            assertEquals(1, db.readCount());

            // write: update db then delete cache
            writeThrough(jedis, db, cacheKey, "1", "v2");
            assertNull(jedis.get(cacheKey));

            // next read: miss -> db
            String v3 = readThrough(jedis, db, cacheKey, "1");
            assertEquals("v2", v3);
            assertEquals(2, db.readCount());
        }
    }

    private String readThrough(Jedis jedis, FakeDb db, String cacheKey, String id) {
        String cached = jedis.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        String v = db.get(id);
        if (v != null) {
            jedis.setex(cacheKey, 60, v);
        }
        return v;
    }

    private void writeThrough(Jedis jedis, FakeDb db, String cacheKey, String id, String newValue) {
        db.put(id, newValue);
        jedis.del(cacheKey);
    }
}
