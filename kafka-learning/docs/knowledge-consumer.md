# Consumer 必须掌握知识点（对应 assessment Consumer/重复消费/offset）

## 1. 手动提交 offset

### 概念

- 通过 `commitSync/commitAsync` 控制 offset 提交时机。

### 必会要点

- 常见实践：业务处理完成后再提交 offset（降低丢处理结果的概率）。
- 提交粒度：按批提交通常更高吞吐，但要接受“批内重复”的可能。

### 常见坑

- 处理成功但提交失败会导致重复消费。

### 对应考核

- Consumer 验收：`consume` 每次 poll 后 `commitSync`。

## 2. auto.offset.reset

### 概念

- 当 group 在该 partition 上没有已提交 offset 时，决定从哪里开始。

### 必会要点

- `earliest`：从最早可用处读。
- `latest`：从最新处读。

### 对应考核

- 知识题 7：`auto.offset.reset=earliest/latest` 的含义。

## 3. Rebalance 与重复消费

### 概念

- group 成员变化或消费不健康时触发分区再分配。

### 必会要点

- rebalance 期间如果 offset 提交与处理边界不清晰，容易出现重复消费。

### 对应考核

- 知识题 3：什么情况下会发生重复消费。

## 4. 业务幂等

### 概念

- 消费端去重/幂等通常通过业务唯一键实现（例如订单号、事件ID）。

### 必会要点

- Kafka 提供的语义并不能替代业务幂等。

