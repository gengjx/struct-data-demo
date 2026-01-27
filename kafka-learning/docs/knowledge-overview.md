# Kafka 学习知识点总览（对应 assessment）

目标：学完每个知识点，能回答 `docs/assessment.md` 的考核题，并能在本项目中完成对应实操。

## 推荐学习顺序

1. 基础概念与架构（Topic/Partition/Replica、Group/Offset）
2. Producer（可靠性、幂等、事务、批量/压缩）
3. Consumer（手动提交、rebalance、重复消费与幂等）
4. 可靠性语义（丢失/重复/Exactly-once 语境）
5. 错误处理与 DLT（重试策略、死信治理与回放）
6. 性能与容量规划（分区规划、吞吐与成本）

## 文档与考核对应关系

- `docs/assessment.md`
  - 概念题（1/2/8/9）：
    - `docs/knowledge-core-concepts.md`
    - `docs/knowledge-performance-and-capacity.md`
  - 可靠性（重复/丢失/语义、幂等/事务）：
    - `docs/knowledge-delivery-semantics.md`
    - `docs/knowledge-producer.md`
    - `docs/knowledge-consumer.md`
  - DLT：
    - `docs/knowledge-error-handling-and-dlt.md`

## 建议练习方式

1. 先跑通环境：`docker compose up -d`
2. 每个主题至少完成：
   - 运行本项目对应命令（produce/consume/consume-dlt/tx）
   - 记录 1 个“踩坑/现象”与解释
3. 每周复盘：
   - 你遇到的 3 个重复/丢失风险点
   - 你最常用的 3 个分区与 key 设计模式
   - 你对 offset 提交策略的选择标准
