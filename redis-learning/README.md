# redis-learning

本模块用于在本仓库内完成 Redis 从入门到进阶的实践与考核产出。

## 1. 环境准备

本模块自带 `docker-compose.yml`，会启动一个带密码的 Redis：

- host: `127.0.0.1`
- port: `6379`
- password: `redis123`

启动：

- 在 `redis-learning` 目录下执行：`docker compose up -d`

停止：

- 在 `redis-learning` 目录下执行：`docker compose down`

## 2. 运行方式

本模块以 JUnit 用例形式提供示例（避免引入额外框架）。

- 先确保 Redis 已启动
- 再运行测试：`redis-learning/src/test/java` 下的用例

## 3. 配置（可选）

如果你不使用默认 Redis 配置，可通过环境变量覆盖：

- `REDIS_HOST`（默认 `127.0.0.1`）
- `REDIS_PORT`（默认 `6379`）
- `REDIS_PASSWORD`（默认 `redis123`）

## 4. 学习内容入口

- 代码示例：`src/test/java/com/struct/redis/`
- 知识考核：`knowledge-assessment.md`
