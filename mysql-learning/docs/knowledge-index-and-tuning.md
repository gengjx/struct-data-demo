# 索引与调优必须掌握知识点（对应 questions-index-and-tuning）

## 1. InnoDB 索引基础

### 概念

- InnoDB 主键是聚簇索引；二级索引叶子节点存主键值。
- 查询能否快，取决于是否能用索引缩小扫描范围。

### 必会要点

- 联合索引与最左前缀
- 覆盖索引、回表
- 选择性（区分度）对索引价值影响

### 常见坑

- 联合索引列顺序错误（把低选择性列放最前）。
- 以为“建了索引就一定走”，但优化器会根据成本选择。

## 2. EXPLAIN/执行计划解读

### 必看字段

- `type`：从好到差常见有 `const/ref/range/index/all`
- `key`：最终使用的索引
- `rows`：预估扫描行数
- `Extra`：`Using filesort`、`Using temporary`、`Using index` 等

### 常见坑

- 只看是否走索引，不看 `rows`（可能走错索引仍然扫描很多）。

## 3. 排序 + 分页优化（典型高频）

### 模式

- 查询：`WHERE user_id = ? ORDER BY created_at DESC LIMIT 20`
- 常用索引：`(user_id, created_at)`

### 深分页优化

- 方案：基于游标（seek method）
- 示例：
  - 先拿到第 1000 条的 `created_at` 或 `id`
  - 再 `WHERE user_id=? AND created_at < ? ORDER BY created_at DESC LIMIT 20`

### 对应题目

- 题 1、题 2

## 4. 覆盖索引

### 概念

- 查询字段都在索引里，`Extra` 可能出现 `Using index`，可避免回表。

### 对应题目

- 题 3

## 5. 索引失效/效果差的常见原因

### 典型原因

- 对索引列做函数/表达式：`DATE(created_at)=...`
- 隐式类型转换：字符串列用数字比较、反之亦然
- `LIKE '%xxx'` 前置通配符
- `OR` 连接不同列条件（可考虑改写 `UNION ALL`）

### 对应题目

- 题 4

## 6. 统计类 SQL 的优化思路

### 常见策略

- 建合适索引减少扫描
- 避免不必要的 JOIN
- 必要时做汇总表/异步聚合

### 对应题目

- 题 5
