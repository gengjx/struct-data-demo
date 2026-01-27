# 11. 运维、性能与安全治理

## 1. 必备运维命令

- `INFO`（重点：memory、stats、replication）
- `SLOWLOG GET` / `SLOWLOG LEN`
- `CLIENT LIST`
- `MEMORY USAGE key`
- `SCAN`（替代 `KEYS`）

## 2. 性能问题定位思路

- 慢：慢命令、大 key、Lua 脚本耗时、网络抖动、连接池问题
- 抖：热 key、CPU 打满、fork 带来的抖动（持久化）

## 3. BigKey / HotKey 治理

- BigKey：拆分、分桶、避免单 key 存过多元素
- HotKey：本地缓存、分片 key、限流、读写分离

## 4. 安全

- 生产必须：密码、ACL、网络隔离
- 禁用危险命令（按需）：`FLUSHALL`、`CONFIG` 等
- 备份与演练：RDB/AOF 备份、恢复演练

## 5. 客户端工程化（Java）

- 超时：连接/读写超时
- 重试：只对幂等读做可控重试
- 连接池：避免连接泄露
- 序列化：避免 JDK 序列化，关注兼容性
