# 10. Redis Cluster：分片与约束

## 1. 核心概念

- 16384 槽（slot）
- key -> slot（CRC16 计算）
- 节点负责一段 slot 范围

## 2. 多 key 操作限制

- 多 key 命令（如 `MGET`、事务、Lua）要求 key 在同一 slot
- 解决：hash tag（`{}`），例如：`order:{123}:a`、`order:{123}:b`

## 3. 扩缩容

- 迁移 slot（reshard）会带来额外开销
- 生产环境要做容量评估与压测

## 4. 设计建议

- 先做 key 规范与 hash tag 设计
- 业务需要多 key 原子操作时，提前规划落在同一 slot
