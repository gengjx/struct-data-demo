# Kafka 学习项目产出：知识考核与验收

建议先阅读知识文档，再完成本页考核：

- `docs/knowledge-overview.md`
- `docs/knowledge-core-concepts.md`
- `docs/knowledge-producer.md`
- `docs/knowledge-consumer.md`
- `docs/knowledge-delivery-semantics.md`
- `docs/knowledge-error-handling-and-dlt.md`
- `docs/knowledge-performance-and-capacity.md`

## 一、实操验收清单（可作为交付产出）

### 1. 环境验收
- **验收项**：可以用 `docker compose up -d` 启动 Kafka（KRaft）
- **验收项**：`localhost:9092` 可用
- **验收项**：Topic 自动创建成功：
  - `kafka.learning.demo`
  - `kafka.learning.demo.dlt`

### 2. Producer 验收
- **验收项**：运行 `produce` 能成功写入消息并输出 `partition/offset`
- **验收项**：说明为什么 `key` 会影响分区分布与同 key 有序
- **验收项**：能讲清楚 `acks=all` 与 `min.insync.replicas` 的关系

### 3. Consumer（手动提交）验收
- **验收项**：运行 `consume` 能持续消费并在每次 poll 后 `commitSync`
- **验收项**：能说明在“业务处理完成后再提交 offset”的意义
- **验收项**：能说出“重复消费产生的原因”以及“业务幂等”的解决思路

### 4. 失败重试 + DLT 验收
- **验收项**：生产包含 `FAIL` 的消息
- **验收项**：`consume-dlt` 会重试 3 次，失败后把原始信息写入 `kafka.learning.demo.dlt`
- **验收项**：能说明 DLT 的使用边界：
  - 什么时候应该进入 DLT
  - 进入 DLT 后如何补偿/回放

### 5. 事务（Exactly-Once 相关）验收
- **验收项**：运行 `tx` 可以提交事务并成功写入 5 条消息
- **验收项**：能说明事务与幂等的差别
- **验收项**：能说明“Kafka 的 exactly-once”在语境上通常指什么（生产/消费/处理链路）

## 二、知识考核题（含答案要点）

### 1. Topic/Partition/Replica 分别解决什么问题？
- **答案要点**：
  - Topic：逻辑分类
  - Partition：并行度/吞吐扩展/同分区有序
  - Replica：容灾/高可用

### 2. 为什么同一个 consumer group 内，单个 partition 只能分配给一个 consumer？
- **答案要点**：
  - 为了保证同分区内的消息顺序与 offset 单调推进
  - 避免多个 consumer 并发提交 offset 造成错乱

### 3. 什么情况下会发生“重复消费”？
- **答案要点**：
  - 业务处理成功但 offset 提交失败
  - rebalance 期间未提交完成
  - consumer 崩溃/超时导致分区被重新分配

### 4. 什么情况下会发生“消息丢失”？如何降低概率？
- **答案要点**：
  - producer：acks=0/1、未 flush、客户端异常
  - broker：副本不足、ISR 缩小、错误配置
  - consumer：自动提交导致先提交后处理
  - 对策：acks=all、幂等、合理重试、手动提交、监控 ISR/URP

### 5. `enable.idempotence=true` 带来什么？它解决了什么问题？
- **答案要点**：
  - producer 侧去重（同一 producer session 内）
  - 解决网络抖动/重试导致的重复写入
  - 不等于端到端 exactly-once

### 6. Kafka 事务用来解决什么问题？
- **答案要点**：
  - 把多条消息写入变成原子性（要么都可见要么都不可见）
  - 与幂等结合，降低重复/部分成功

### 7. `auto.offset.reset=earliest/latest` 的含义是什么？
- **答案要点**：
  - 仅在“没有已提交 offset”时生效
  - earliest：从最早可用处读；latest：从最新处读

### 8. Kafka 为什么吞吐高？
- **答案要点**：
  - 顺序写磁盘 + 分段文件
  - 批量发送/压缩
  - 网络零拷贝（底层机制概念）

### 9. 分区数如何规划？
- **答案要点**：
  - 并行度：<= consumer 实例数
  - 吞吐：单分区极限、热点 key
  - 运维成本：过多分区带来文件句柄/内存/控制面压力

### 10. DLT 与“无限重试”的取舍？
- **答案要点**：
  - 无限重试会阻塞消费并导致堆积
  - DLT 让异常可观测/可补偿，但要配套回放/治理流程
