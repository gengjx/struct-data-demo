# MySQL 基础必须掌握知识点（对应 questions-basic）

## 1. DDL：库表与约束

### 概念

- 表结构是业务约束与查询性能的基础。
- InnoDB 下主键是聚簇索引（数据按主键组织）。

### 必会语法/要点

- `CREATE DATABASE` / `USE`
- `CREATE TABLE`：字段类型、默认值、`NOT NULL`、`AUTO_INCREMENT`
- 约束：`PRIMARY KEY`、`UNIQUE KEY`
- 二级索引：`KEY idx_xxx (...)`
- 时间字段：`DATETIME`、`DEFAULT CURRENT_TIMESTAMP`

### 常见坑

- 字段类型选错：金额用 `DECIMAL`/`INT(分)`，不要用 `FLOAT/DOUBLE` 存钱。
- 字符集/排序规则不统一导致比较/索引行为异常。
- 约束与索引的关系：`UNIQUE` 本质上会创建唯一索引。

### 对应题目

- 题 1（建表）

## 2. DML：增删改

### 概念

- 写入类 SQL 要考虑幂等、误操作风险、影响行数。

### 必会语法/要点

- `INSERT INTO ... VALUES (...)`
- `UPDATE ... SET ... WHERE ...`
- `DELETE FROM ... WHERE ...`

### 常见坑

- `UPDATE/DELETE` 忘记 `WHERE`。
- `WHERE` 条件不走索引导致锁范围变大（更新/删除也需要索引）。
- 使用 `NULL` 的比较要用 `IS NULL`。

### 对应题目

- 题 2（插入）
- 题 8（更新）
- 题 9（删除）

## 3. 基础查询：过滤、排序、分页

### 概念

- 查询性能的核心：尽量减少扫描行数、减少排序/临时表。

### 必会语法/要点

- `SELECT ... FROM ... WHERE ...`
- `ORDER BY ... DESC` + `LIMIT n`

### 常见坑

- 对列做函数运算（例如 `DATE(created_at)=...`）会影响索引利用。
- 深分页 `LIMIT offset,size` 越往后越慢（后续在调优章节解决）。

### 对应题目

- 题 3（过滤+排序+分页）

## 4. 聚合统计：GROUP BY / HAVING

### 概念

- `GROUP BY` 先分组再聚合；`HAVING` 用于对聚合结果再次过滤。

### 必会语法/要点

- `COUNT(*)` / `COUNT(col)`
- `GROUP BY`、`HAVING COUNT(...) >= ...`

### 常见坑

- 只用 `WHERE` 无法表达对聚合结果的过滤，必须用 `HAVING`。
- `LEFT JOIN` + `COUNT` 时注意 `COUNT(*)` 与 `COUNT(o.id)` 的差异。

### 对应题目

- 题 4（每个用户订单数，包含 0）
- 题 5（按天聚合）
- 题 7（至少 2 单）

## 5. 多表关联：JOIN

### 概念

- `JOIN` 的关键在于：连接条件、连接方向（左/内）、以及被驱动表的索引。

### 必会语法/要点

- `INNER JOIN`：只保留匹配行
- `LEFT JOIN`：保留左表全部行

### 常见坑

- 连接条件写错导致笛卡尔积。
- 缺少连接字段索引导致大量扫描。

### 对应题目

- 题 4（LEFT JOIN）
- 题 6（订单明细多表 JOIN）

## 6. 业务查询与索引意识（入门）

### 概念

- 先有查询，再反推索引。

### 必会语法/要点

- 识别“高频查询”与“排序分页”场景
- 联合索引通常按：等值条件列在前、排序列在后

### 常见坑

- 过度建索引：写入变慢、占空间、维护成本高。

### 对应题目

- 题 10（自拟业务查询 + 索引设计）
