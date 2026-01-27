# 07. 限流：固定窗口与实践

## 1. 限流常见算法

- 固定窗口
- 滑动窗口
- 令牌桶
- 漏桶

## 2. 固定窗口（本模块实现）

思路：
- 用 `INCR` 计数
- 第一次计数时设置窗口 TTL
- 超过阈值返回拒绝

为什么要用 Lua：
- `INCR` + `EXPIRE` + 判断需要原子性

本仓库对应：
- `com.struct.redis.ratelimit.FixedWindowRateLimiter`
- `RateLimiterLuaTest`

## 3. 工程建议

- 维度设计：按用户、IP、接口、租户等
- 返回策略：拒绝、排队、降级
- 监控：拒绝率、阈值命中、Redis RT
