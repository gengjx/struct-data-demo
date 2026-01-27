# Redis 学习考核（redis-learning 模块产出）

## 1. 概念题（必答）

1. Redis 为什么快？单线程指的是什么？哪些操作会阻塞？
2. Redis 的数据结构有哪些？分别适用于什么场景？
3. 过期删除策略是什么？淘汰策略有哪些？如何选型？
4. 缓存穿透/击穿/雪崩的区别与治理手段是什么？
5. Pipeline 的收益与风险是什么？
6. `SCAN` 相比 `KEYS` 的优势与注意点是什么？
7. Redis 事务 `MULTI/EXEC` 的语义是什么？为什么它不是数据库事务？
8. Lua 脚本为什么能保证原子性？Lua 脚本需要注意什么（执行时间、可重入、数据量）？
9. 分布式锁正确姿势是什么？只用 `SETNX` 有哪些坑？
10. 主从复制的全量/增量过程是什么？复制延迟会导致什么问题？
11. 哨兵的作用是什么？如何避免脑裂风险？
12. Cluster 的分片机制是什么？为什么是 16384 槽？

## 2. 命令题（必答）

1. 查看内存：`INFO MEMORY`、`MEMORY USAGE key`
2. 查看慢日志：`SLOWLOG GET`、`SLOWLOG LEN`
3. 查看客户端连接：`CLIENT LIST`
4. 查看 key 过期时间：`TTL key` / `PTTL key`
5. ZSet 排行榜：`ZADD`、`ZREVRANGE WITHSCORES`、`ZREVRANK`

## 3. 实操题（必须在本模块中完成并验收）

### 3.1 数据结构（30 分）

- String：实现一个计数器（带 TTL）
- Hash：实现一个用户 profile 的读写
- List：实现简单队列 push/pop（说明其局限）
- Set：实现去重
- ZSet：实现 TopN 排行榜

验收：跑通 `RedisDataStructureTest`

### 3.2 缓存旁路 Cache Aside（20 分）

- 实现读：先查 Redis，未命中则“查 DB（用内存 Map 模拟）”并回填
- 实现写：写 DB，再删除缓存（说明一致性策略）

验收：跑通 `CacheAsideTest`

### 3.3 分布式锁（20 分）

- 使用 `SET key value NX PX` 获取锁
- 使用 Lua 脚本（value 校验）释放锁

验收：跑通 `RedisLockTest`

### 3.4 Lua 限流（20 分）

- 使用 Lua 实现滑动窗口/固定窗口限流（任选其一）
- 输出允许/拒绝

验收：跑通 `RateLimiterLuaTest`

### 3.5 延迟队列（10 分）

- 使用 ZSet 实现延迟任务（score=执行时间戳）
- 实现 poll：取到期任务并删除

验收：跑通 `DelayQueueTest`

## 4. 评分标准

- 代码可运行（必须）：40%
- 关键点解释清楚（为什么这么写、有哪些坑）：40%
- 产出文档完整（Key 规范、TTL 策略、压测/监控建议）：20%
