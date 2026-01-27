# 工程化与生产必须掌握知识点（对应 questions-engineering）

## 文档索引（建议按题目学习）

1. 题 1：主键选型
   - `docs/knowledge-engineering-primary-key.md`
2. 题 2：归档/冷热分离
   - `docs/knowledge-engineering-archiving.md`
3. 题 3：主从复制与一致性
   - `docs/knowledge-engineering-replication-consistency.md`
4. 题 4：备份恢复
   - `docs/knowledge-engineering-backup-restore.md`
5. 题 5：大表 DDL 变更
   - `docs/knowledge-engineering-online-ddl.md`

## 1. 主键选型

### 常见方案

- 自增主键：简单但可能有主从/分库分表扩展问题
- 雪花/号段：常见于分布式场景

### 为什么不推荐 UUID 直接做主键（典型点）

- 随机性强导致 B+Tree 页分裂、写放大
- 索引占用空间大
- 聚簇索引下数据物理组织不友好，范围查询性能差

### 对应题目

- 题 1

## 2. 归档/冷热分离

### 思路

- 按时间分段：近数据留在线库，老数据归档到历史库/冷库
- 关键是：查询路径、归档策略、回查机制

### 对应题目

- 题 2

## 3. 主从复制与一致性

### 概念

- 主从复制基于 binlog，存在延迟。

### 常见问题

- 读写分离后从库读不到刚写的数据（读己之写问题）。

### 常见解决思路

- 关键读走主库
- 半同步/增强一致性策略
- 基于 GTID/位点等待（中间件能力）

### 对应题目

- 题 3

## 4. 备份恢复

### 关键点

- 全量+增量/日志
- 备份校验
- 定期恢复演练

### 对应题目

- 题 4

## 5. 大表 DDL 变更

### 风险

- 元数据锁（MDL）阻塞读写
- 变更耗时长导致业务抖动

### 低风险思路

- Online DDL（视具体变更类型）
- 影子表/在线变更工具（pt-osc/gh-ost 的思想）
- 变更窗口、灰度、可回滚

### 对应题目

- 题 5
