# kafka-learning

## 本地启动 Kafka

在本模块目录执行：

- `docker compose up -d`

启动后默认使用 `localhost:9092`。

## 运行示例

所有示例都通过 `exec-maven-plugin` 启动：

- 生产（幂等 + acks=all + 压缩/批量参数）：
  - `mvn -pl kafka-learning -Dexec.args=produce exec:java`

- 消费（手动提交 offset）：
  - `mvn -pl kafka-learning -Dexec.args=consume exec:java`

- 消费失败重试，超过次数写入 DLT：
  - `mvn -pl kafka-learning -Dexec.args=consume-dlt exec:java`

- 事务生产：
  - `mvn -pl kafka-learning -Dexec.args=tx exec:java`

## 环境变量

- `KAFKA_BOOTSTRAP_SERVERS`：默认 `localhost:9092`
- `KAFKA_GROUP_ID`：默认 `kafka-learning-group`

## Topics

程序启动时会自动创建：

- `kafka.learning.demo`
- `kafka.learning.demo.dlt`
