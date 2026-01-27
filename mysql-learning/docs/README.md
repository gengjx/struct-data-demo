# mysql-learning

## 启动 MySQL

在 `mysql-learning/` 目录下执行：

```bash
docker compose up -d
```

默认连接信息：

- host: `localhost`
- port: `3306`
- user: `root`
- password: `root`
- database: `mysql_learning`

初始化脚本位于 `sql/00_schema_and_seed.sql`，容器首次启动会自动执行。

## 练习与考核

- 题库：
  - `docs/questions-basic.md`
  - `docs/questions-index-and-tuning.md`
  - `docs/questions-transaction-and-lock.md`
  - `docs/questions-engineering.md`
- 参考答案：`docs/answers.sql`

## 自测校验

你可以把作答SQL写到 `exam/solutions.sql`，然后在项目根执行：

```bash
mvn -pl mysql-learning -DskipTests exec:java
```

可通过环境变量覆盖连接信息：

- `MYSQL_HOST`（默认 `localhost`）
- `MYSQL_PORT`（默认 `3306`）
- `MYSQL_DB`（默认 `mysql_learning`）
- `MYSQL_USER`（默认 `root`）
- `MYSQL_PASSWORD`（默认 `root`）
