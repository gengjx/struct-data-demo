# 08. 延迟队列：ZSet 实现与可靠性

## 1. 基本实现

- 队列 key：`dq:{biz}`
- `offer(payload, executeAt)`：`ZADD key executeAt payload`
- `poll(now)`：取 `score <= now` 的最早一条并删除

本仓库对应：
- `com.struct.redis.delay.RedisDelayQueue`
- `DelayQueueTest`

## 2. 常见问题

- **并发消费**：多个消费者同时 poll 可能重复取到，需要“取+删”具备原子性
  - 本实现用 `ZRANGEBYSCORE` + `ZREM`，并发下仍可能竞争失败（通过检查 `ZREM` 返回值兜底）
  - 更严谨可用 Lua 将“取+删”做成原子脚本
- **payload 唯一性**：同 payload 会覆盖/冲突，建议 payload 使用唯一 ID

## 3. 可靠性增强（进阶）

- 使用 Lua 原子 pop
- 取出后放入 processing 集合，配合超时回补
- 与 DB 状态结合，保证最终一致
