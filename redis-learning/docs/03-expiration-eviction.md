# 03. 过期、删除与淘汰策略

## 1. 过期（expiration）

- **设置**：`EXPIRE/PEXPIRE`、`SETEX`、`SET key val EX/PX`
- **查看**：`TTL/PTTL`

## 2. 过期删除策略

- **惰性删除**：访问 Key 时发现过期再删除
- **定期删除**：后台周期性扫描部分过期 Key

含义：
- 过期 Key 不一定会“立刻消失”，但对业务语义通常无影响（读不到）

## 3. 内存淘汰（eviction）

当内存达到上限（`maxmemory`）时：
- 常见策略：
  - `allkeys-lru`：所有 key 参与 LRU
  - `volatile-lru`：仅带 TTL 的 key 参与 LRU
  - `allkeys-random` / `volatile-random`
  - `volatile-ttl`：优先淘汰 TTL 更短的
  - `noeviction`：不淘汰，写入报错

## 4. 工程建议

- 缓存类 key **必须设置 TTL**，否则 `volatile-*` 类策略可能失效
- 线上避免出现大量近似 TTL 的 key（雪崩风险）
- 对“必须存在”的数据不要放 Redis 当唯一存储（Redis 是缓存/中间态更合适）
