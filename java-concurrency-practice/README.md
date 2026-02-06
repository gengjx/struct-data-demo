# Java并发编程学习练习

本模块用于学习和巩固 Java 并发编程基础能力，覆盖线程基础、共享变量可见性与原子性、常用并发工具类、线程池与异步编排等内容。

## 📚 学习路线

### 第一部分：线程基础
- **ThreadCreationDemo.java** - 线程创建与运行
  - 平台线程（Platform Thread）
  - 虚拟线程（Virtual Thread，JDK 21+）

### 第二部分：共享变量与线程安全
- **SynchronizedCounterDemo.java** - `synchronized` 实现互斥与可见性
  - 临界区与互斥
  - 可见性保证
- **ReentrantLockCounterDemo.java** - `ReentrantLock` 显式锁
  - `lock/unlock` 配对
  - `try/finally` 保证释放锁
- **AtomicCounterDemo.java** - 原子类与 CAS
  - `AtomicInteger` 原子自增

### 第三部分：线程池与任务执行
- **ExecutorServiceDemo.java** - `ExecutorService` 提交任务与获取结果
  - `submit(Callable)`
  - `Future#get()`
  - 线程池关闭与等待终止

### 第四部分：异步编排
- **CompletableFutureDemo.java** - `CompletableFuture` 异步组合
  - `supplyAsync`
  - `thenCombine`

### 第五部分：并发工具类
- **CountDownLatchDemo.java** - `CountDownLatch` 等待多个任务完成

### 第六部分：线程本地变量
- **ThreadLocalDemo.java** - `ThreadLocal` 隔离线程上下文

## 🚀 使用方法

### 1) 运行示例

本模块提供统一入口类：`com.struct.concurrency.ConcurrencyLearningApp`。

在仓库根目录执行（需要本机可用 `mvn`）：

```bash
mvn -pl java-concurrency-practice exec:java -Dexec.args=thread
```

可用参数：
- `thread`
- `sync`
- `lock`
- `atomic`
- `executor`
- `future`
- `latch`
- `threadlocal`

### 2) 运行测试

```bash
mvn -pl java-concurrency-practice test
```

## 📝 学习建议

1. 先看 `理论知识.md` 建立 JMM、happens-before、锁与 CAS 的整体认知
2. 对照 demo 代码运行与修改参数（线程数、循环次数），观察现象与性能差异
3. 逐步扩展：添加更多工具类（`Semaphore`、`CyclicBarrier`、`ReadWriteLock`、`BlockingQueue`）与典型问题（死锁、活锁、饥饿）

## 📖 推荐资源

- 《Java并发编程实战》
- 《Java并发编程的艺术》
- OpenJDK `java.util.concurrent` 源码
