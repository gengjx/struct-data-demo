# Producer 必须掌握知识点（对应 assessment Producer/幂等/事务）

## 1. 可靠性参数：acks / retries / timeout

### 概念

- acks 决定 broker 侧确认条件。

### 必会要点

- `acks=all`：等待 ISR 内副本都确认（结合 topic 的 `min.insync.replicas` 才完整）。
- 合理重试：网络抖动时常见，需要与幂等一起使用降低重复写入。

### 常见坑

- 只配置 `acks=all` 但 `min.insync.replicas` 过低，可靠性预期与现实不一致。

### 对应考核

- Producer 验收：解释 `acks=all` 与 `min.insync.replicas` 的关系。

## 2. key 与分区

### 概念

- key 决定分区策略（默认哈希分区），影响有序性与热点。

### 必会要点

- 同 key 一般落同一分区，可保证同 key 有序。
- key 设计要兼顾：并行度（分散）与有序性（聚合）。

### 常见坑

- key 过于集中造成热点分区。

### 对应考核

- Producer 验收：说明 key 会影响分区与同 key 有序。

## 3. 幂等生产（enable.idempotence=true）

### 概念

- Producer 端在重试时避免“同一条消息被写入多次”的能力。

### 必会要点

- 幂等解决的是“Producer 重试导致的重复写入”，不是端到端 exactly-once。

### 对应考核

- 知识题 5：`enable.idempotence=true` 带来什么。

## 4. 事务生产（transactional.id）

### 概念

- 让多条写入具备原子性：要么全部可见，要么全部不可见。

### 必会要点

- 事务通常与幂等配合。

### 对应考核

- 实操：`tx` 能提交事务写入。
- 知识题 6：Kafka 事务解决什么问题。

