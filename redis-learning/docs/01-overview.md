# 01. Redis 概览与学习目标

## 1. Redis 是什么

- **定位**：内存数据结构服务器（in-memory data structure store）
- **常见用途**：缓存、计数器、排行榜、分布式锁、限流、延迟队列、会话存储

## 2. Redis 为什么快（面试高频）

- **内存读写**：数据主要在内存中
- **高效的数据结构实现**：字符串/哈希/跳表等
- **事件驱动模型**：I/O 多路复用 + 单线程执行命令
- **减少上下文切换**：命令执行阶段主要由单线程串行完成

> 说明：Redis 所谓“单线程”指 **命令执行的主线程**，并不代表 Redis 没有后台线程（持久化、AOF 重写等会涉及后台线程或子进程）。

## 3. 你要掌握到什么程度

- **会用**：熟练五大数据结构、TTL、常用命令
- **写得对**：能处理缓存穿透/击穿/雪崩，理解原子性
- **可上线**：理解 RDB/AOF、主从/哨兵、Cluster 约束
- **专业化**：性能调优、BigKey/HotKey 治理、可观测性、安全治理

## 4. 本仓库对应落地

- **代码入口**：`redis-learning/src/main/java` 与 `src/test/java`
- **实操验收**：跑通 `redis-learning/src/test/java/com/struct/redis/*Test.java`
- **考核题库**：`redis-learning/knowledge-assessment.md`
