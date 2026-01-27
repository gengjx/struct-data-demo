# Kafka 基础概念必须掌握知识点（对应 assessment 概念题）

## 1. Topic / Partition / Replica

### 概念

- Topic：消息的逻辑分类。
- Partition：同一 Topic 内的物理分片。
- Replica：分区副本（通常包含 leader 与 follower）。

### 必会要点

- 吞吐扩展靠分区：Producer/Consumer 的并行度最终落在 partition 上。
- 有序性边界：默认只保证“同分区内”有序。
- 容灾靠副本：leader 故障后可切换。

### 常见坑

- 误以为 Topic 内全局有序。
- 分区数过少导致扩展困难，分区数过多导致运维成本上升。

### 对应考核

- 概念题 1：Topic/Partition/Replica 分别解决什么问题。

## 2. Producer / Consumer / Consumer Group

### 概念

- Producer：写消息到 Topic。
- Consumer：从 Topic 读消息。
- Consumer Group：消费端的并行与容错单位。

### 必会要点

- 同一个 group 内：一个 partition 同一时刻只会分配给一个 consumer。
- group 规模的上限：consumer 数量超过 partition 数不会增加并行度。

### 常见坑

- group 内多个 consumer 争抢同一 partition（Kafka 不允许，会导致某些 consumer 空闲）。

### 对应考核

- 概念题 2：为什么同一个 consumer group 内，单个 partition 只能分配给一个 consumer。

## 3. Offset

### 概念

- Offset：消费者在某个 partition 上的消费进度。

### 必会要点

- offset 由 consumer group 维度维护。
- offset 提交时机决定了重复/丢失风险。

### 常见坑

- 自动提交：可能出现“先提交后处理”，导致处理失败但 offset 已前进。

