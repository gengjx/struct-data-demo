# 可靠性与投递语义必须掌握知识点（对应 assessment 重复/丢失/Exactly-Once）

## 1. 常见投递语义

### 概念

- At-most-once：最多一次（可能丢，不重复）。
- At-least-once：至少一次（不丢，但可能重复）。
- Exactly-once：精确一次（需要限定语境）。

### 必会要点

- Kafka 语境下的 exactly-once 通常指：
  - Producer 侧幂等 + 事务，保证写入原子性与去重。
  - 或处理链路（如 Kafka Streams）在特定配置下实现端到端一致。

## 2. 消息丢失的典型场景与对策

### 典型场景

- Producer：acks 配置过低、未 flush/未等待回执、异常退出。
- Broker：ISR 缩小、错误的副本/ISR 配置。
- Consumer：自动提交导致先提交后处理。

### 对策要点

- `acks=all` + 合理 `min.insync.replicas`。
- 幂等/事务降低重复与部分成功。
- Consumer 手动提交 + 业务幂等。

### 对应考核

- 知识题 4：什么时候会丢失，如何降低概率。

## 3. 重复消费的来源与治理

### 典型来源

- 处理成功但 offset 提交失败。
- rebalance 导致分区迁移。

### 治理要点

- 业务幂等。
- 合理提交策略与监控。

### 对应考核

- 知识题 3：重复消费场景。

