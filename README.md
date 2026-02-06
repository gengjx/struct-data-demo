# struct-data-demo

这是一个用于学习与巩固的多模块 Java 进阶仓库，内容包含：
- 数据结构与算法（实现 + 练习）
- Java 基础/进阶/高级练习
- MySQL / Redis / Kafka 等常见中间件的学习记录

## 环境要求

- JDK：25
- 构建工具：Maven（多模块工程，编译参数统一由父 `pom.xml` 管控）

## 目录结构（模块索引）

### 数据结构与算法
- `data-structure-algorithm-practice`：数据结构与算法综合练习（TODO 驱动）
- `array-demo`：数组相关示例
- `linkedList-demo`：链表相关示例
- `stack`：栈相关示例
- `queue-demo`：队列相关示例
- `sorts`：排序算法示例
- `heap`：堆与堆排序示例
- `tree`：树相关示例
- `hash-table`：哈希表相关示例
- `skip-list`：跳表相关示例
- `recursive-demo`：递归相关示例
- `serach`：查找相关示例（建议后续更名为 `search`）
- `statck_algo`：栈相关算法练习（建议后续更名为 `stack_algo`）

### Java 学习
- `java-basics-practice`：Java 基础练习
- `java-advanced-practice`：Java 进阶练习
- `java-senior-practice`：Java 高级练习
- `java-testing-practice`：单元测试练习（JUnit5 + Mockito）

### Web / 业务开发
- `spring-boot-web-demo`：Spring Boot Web 最小可运行示例（REST、校验、统一返回、异常处理）

### 数据库 / 中间件
- `mysql-learning`：MySQL 学习记录
- `redis-learning`：Redis 学习记录
- `kafka-learning`：Kafka 学习记录

## 构建与运行

本仓库使用 Maven 多模块工程。

### 1) 构建整个仓库

```bash
mvn -q -DskipTests package
```

### 2) 运行某个模块

以 `data-structure-algorithm-practice` 为例：

```bash
mvn -pl data-structure-algorithm-practice -DskipTests package
```

然后在 IDE 中运行该模块的 `com.struct.practice.Main`。

## 推荐学习路径

1. 先看 `data-structure-algorithm-practice/理论知识.md`
2. 按 `data-structure-algorithm-practice` 中的 TODO 逐个实现
3. 对照各个 demo 模块加深理解（例如堆排序可对照 `heap/HeapSort.java`）
4. 再学习 Java 基础/进阶/高级练习模块
5. 最后学习 MySQL/Redis/Kafka 等中间件模块
