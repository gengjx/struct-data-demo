# 06. 分布式锁：正确姿势与常见坑

## 1. 为什么只用 SETNX 不够

常见错误：
- `SETNX` 成功后没有设置过期时间（死锁风险）
- 解锁时直接 `DEL key`（误删别人的锁）

## 2. 推荐实现（单 Redis 实例场景）

- 加锁：`SET key token NX PX ttl`
  - `token`：唯一标识（UUID/请求ID/线程ID组合）
- 解锁：Lua 校验 token 后删除

本仓库对应：`com.struct.redis.lock.RedisLock` + `RedisLockTest`

## 3. 关键工程点

- **必须设置 TTL**：避免死锁
- **释放必须校验 token**：避免误删
- **业务要可重试且幂等**：锁只是并发控制的一部分

## 4. 高级话题（进阶）

- 锁续期（watch dog）
- 可重入锁
- 多 Redis 节点一致性（RedLock 争议点与适用边界）
