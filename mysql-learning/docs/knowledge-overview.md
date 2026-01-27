# MySQL 学习知识点总览（对应题库）

目标：学完每个知识点，立即回到题库对应题目写 SQL，并使用 `EXPLAIN`/事务会话演练验证。

## 推荐学习顺序

1. 基础 SQL（DDL/DML/查询）
2. 索引与执行计划、SQL 调优
3. 事务隔离、锁、并发一致性
4. 工程化与生产实践

## 与题库的对应关系

- `docs/questions-basic.md`
  - 对应知识文档：`docs/knowledge-basic.md`
- `docs/questions-index-and-tuning.md`
  - 对应知识文档：`docs/knowledge-index-and-tuning.md`
- `docs/questions-transaction-and-lock.md`
  - 对应知识文档：`docs/knowledge-transaction-and-lock.md`
- `docs/questions-engineering.md`
  - 对应知识文档：
    - `docs/knowledge-engineering.md`
    - `docs/knowledge-engineering-primary-key.md`
    - `docs/knowledge-engineering-archiving.md`
    - `docs/knowledge-engineering-replication-consistency.md`
    - `docs/knowledge-engineering-backup-restore.md`
    - `docs/knowledge-engineering-online-ddl.md`

## 建议练习方式

1. 先读知识文档的“常见坑”部分，避免无效练习
2. 每道题至少输出：
   - SQL
   - 结果是否符合预期
   - 若是查询类：加 `EXPLAIN` 并解释 `key/rows/Extra`
3. 每周做一次复盘：
   - 你最常犯的 3 个错误
   - 你最常用的 5 个索引设计模式
   - 你最容易写出长事务/锁等待的 3 个场景
