package com.struct.practice;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis缓存练习
 * 练习内容：
 * 1. Redis基础数据结构
 * 2. Redis常用命令
 * 3. Redis持久化机制
 * 4. Redis缓存策略
 * 5. Redis集群
 */
public class RedisPractice {

    /**
     * 练习1：Redis数据结构
     * 任务：理解Redis的五种基本数据结构
     */
    public static void practice1_RedisDataStructures() {
        System.out.println("=== 练习1：Redis数据结构 ===");
        
        // TODO: 使用Jedis连接Redis并操作各种数据结构
        // Jedis jedis = new Jedis("localhost", 6379);
        
        // 1. String（字符串）
        //    jedis.set("key", "value");
        //    String value = jedis.get("key");
        //    jedis.incr("counter");  // 递增
        
        // 2. Hash（哈希）
        //    jedis.hset("user:1", "name", "John");
        //    jedis.hset("user:1", "age", "30");
        //    String name = jedis.hget("user:1", "name");
        
        // 3. List（列表）
        //    jedis.lpush("list", "item1", "item2");
        //    jedis.rpop("list");
        
        // 4. Set（集合）
        //    jedis.sadd("set", "member1", "member2");
        //    Boolean exists = jedis.sismember("set", "member1");
        
        // 5. Sorted Set（有序集合）
        //    jedis.zadd("sortedSet", 1.0, "member1");
        //    jedis.zadd("sortedSet", 2.0, "member2");
        //    Set<String> members = jedis.zrange("sortedSet", 0, -1);
        
        // jedis.close();
        
        System.out.println("请实现Redis各种数据结构的操作");
    }

    /**
     * 练习2：Redis连接池
     * 任务：使用连接池管理Redis连接
     */
    public static void practice2_RedisPool() {
        System.out.println("\n=== 练习2：Redis连接池 ===");
        
        // TODO: 配置和使用Jedis连接池
        // JedisPoolConfig config = new JedisPoolConfig();
        // config.setMaxTotal(100);  // 最大连接数
        // config.setMaxIdle(20);    // 最大空闲连接数
        // config.setMinIdle(5);     // 最小空闲连接数
        // 
        // JedisPool pool = new JedisPool(config, "localhost", 6379);
        // 
        // try (Jedis jedis = pool.getResource()) {
        //     jedis.set("key", "value");
        // }
        // 
        // pool.close();
        
        System.out.println("请实现Redis连接池的使用");
    }

    /**
     * 练习3：Redis持久化
     * 任务：理解Redis的持久化机制
     */
    public static void practice3_RedisPersistence() {
        System.out.println("\n=== 练习3：Redis持久化 ===");
        
        // TODO: 理解Redis的持久化方式
        // 1. RDB（Redis Database）
        //    - 快照方式，将内存中的数据保存到磁盘
        //    - 优点：文件小，恢复快
        //    - 缺点：可能丢失最后一次快照后的数据
        //    - 配置：save 900 1  # 900秒内至少1个key变化则保存
        
        // 2. AOF（Append Only File）
        //    - 记录所有写操作命令
        //    - 优点：数据更安全，丢失数据少
        //    - 缺点：文件大，恢复慢
        //    - 配置：appendonly yes
        
        // 3. 混合持久化（RDB + AOF）
        //    - Redis 4.0+支持
        //    - 结合RDB和AOF的优点
        
        System.out.println("请理解Redis的持久化机制");
    }

    /**
     * 练习4：Redis缓存策略
     * 任务：掌握常见的缓存策略
     */
    public static void practice4_CacheStrategy() {
        System.out.println("\n=== 练习4：缓存策略 ===");
        
        // TODO: 理解常见的缓存策略
        // 1. Cache-Aside（旁路缓存）
        //    - 应用程序先查缓存，缓存未命中则查数据库，然后写入缓存
        //    - 适合读多写少的场景
        
        // 2. Read-Through（读穿透）
        //    - 缓存服务负责从数据库加载数据并写入缓存
        //    - 应用程序只访问缓存
        
        // 3. Write-Through（写穿透）
        //    - 先写入缓存，再写入数据库
        //    - 保证数据一致性
        
        // 4. Write-Back（写回）
        //    - 先写入缓存，异步写入数据库
        //    - 性能好，但可能丢失数据
        
        // 5. 缓存更新策略
        //    - 定时更新：定时刷新缓存
        //    - 主动更新：数据变化时主动更新缓存
        //    - 失效更新：缓存失效时从数据库加载
        
        System.out.println("请理解常见的缓存策略");
    }

    /**
     * 练习5：缓存穿透、击穿、雪崩
     * 任务：理解缓存常见问题及解决方案
     */
    public static void practice5_CacheProblems() {
        System.out.println("\n=== 练习5：缓存问题 ===");
        
        // TODO: 理解缓存常见问题
        // 1. 缓存穿透（Cache Penetration）
        //    - 问题：查询不存在的数据，每次都查数据库
        //    - 解决：
        //      * 缓存空值（设置较短的过期时间）
        //      * 使用布隆过滤器（Bloom Filter）过滤无效请求
        
        // 2. 缓存击穿（Cache Breakdown）
        //    - 问题：热点数据过期，大量请求直接查数据库
        //    - 解决：
        //      * 设置热点数据永不过期
        //      * 使用互斥锁（mutex），只让一个线程查数据库，其他线程等待
        
        // 3. 缓存雪崩（Cache Avalanche）
        //    - 问题：大量缓存同时过期，请求全部打向数据库
        //    - 解决：
        //      * 缓存过期时间加上随机值
        //      * 使用缓存集群，避免单点故障
        //      * 限流降级
        
        System.out.println("请理解缓存穿透、击穿、雪崩问题及解决方案");
    }

    /**
     * 练习6：Redis事务
     * 任务：理解Redis事务的使用
     */
    public static void practice6_RedisTransaction() {
        System.out.println("\n=== 练习6：Redis事务 ===");
        
        // TODO: 理解Redis事务
        // Redis事务使用MULTI、EXEC、DISCARD、WATCH命令
        
        // Jedis jedis = new Jedis("localhost", 6379);
        // 
        // Transaction transaction = jedis.multi();
        // transaction.set("key1", "value1");
        // transaction.set("key2", "value2");
        // List<Object> results = transaction.exec();
        
        // 注意：
        // - Redis事务不支持回滚
        // - Redis事务是原子性的，但不支持隔离性
        // - WATCH可以监控key的变化，如果key被修改，事务会失败
        
        System.out.println("请理解Redis事务的使用");
    }

    /**
     * 练习7：Redis过期策略
     * 任务：理解Redis的过期键删除策略
     */
    public static void practice7_ExpirationStrategy() {
        System.out.println("\n=== 练习7：过期策略 ===");
        
        // TODO: 理解Redis的过期键删除策略
        // 1. 定时删除
        //    - 为每个过期键设置一个定时器
        //    - 内存友好，但CPU不友好
        
        // 2. 惰性删除
        //    - 访问键时检查是否过期，过期则删除
        //    - CPU友好，但内存不友好
        
        // 3. 定期删除
        //    - 每隔一段时间扫描过期键并删除
        //    - Redis采用惰性删除 + 定期删除
        
        // 设置过期时间：
        // jedis.setex("key", 60, "value");  // 60秒后过期
        // jedis.expire("key", 60);  // 设置过期时间
        
        System.out.println("请理解Redis的过期键删除策略");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_RedisDataStructures();
        practice2_RedisPool();
        practice3_RedisPersistence();
        practice4_CacheStrategy();
        practice5_CacheProblems();
        practice6_RedisTransaction();
        practice7_ExpirationStrategy();
    }
}






