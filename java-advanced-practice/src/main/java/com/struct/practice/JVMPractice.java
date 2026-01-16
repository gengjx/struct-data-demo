package com.struct.practice;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * JVM深入练习
 * 练习内容：
 * 1. JVM内存模型（堆、栈、方法区、程序计数器、本地方法栈）
 * 2. 垃圾回收机制（GC算法、GC收集器）
 * 3. 类加载机制（加载、验证、准备、解析、初始化）
 * 4. JVM调优参数和工具使用
 */
public class JVMPractice {

    /**
     * 练习1：理解JVM内存区域
     * 任务：了解各个内存区域的作用和特点
     */
    public static void practice1_MemoryAreas() {
        System.out.println("=== 练习1：JVM内存区域 ===");
        
        // TODO: 了解以下内存区域的特点
        // 1. 程序计数器（Program Counter Register）
        //    - 线程私有，记录当前线程执行的字节码指令地址
        //    - 唯一不会发生OOM的区域
        
        // 2. Java虚拟机栈（Java Virtual Machine Stack）
        //    - 线程私有，生命周期与线程相同
        //    - 每个方法执行时会创建一个栈帧（Stack Frame）
        //    - 栈帧包含：局部变量表、操作数栈、动态链接、方法返回地址
        //    - 可能出现StackOverflowError和OutOfMemoryError
        
        // 3. 本地方法栈（Native Method Stack）
        //    - 线程私有，为Native方法服务
        
        // 4. Java堆（Java Heap）
        //    - 线程共享，存放对象实例
        //    - 新生代（Eden、Survivor0、Survivor1）和老年代
        //    - 可能出现OutOfMemoryError
        
        // 5. 方法区（Method Area）/ 元空间（Metaspace）
        //    - 线程共享，存储类信息、常量、静态变量、即时编译器编译后的代码
        //    - Java 8之前是永久代（PermGen），Java 8之后是元空间（Metaspace）
        
        // 6. 运行时常量池（Runtime Constant Pool）
        //    - 方法区的一部分，存放编译期生成的各种字面量和符号引用
        
        System.out.println("请阅读注释，理解各个内存区域的作用");
    }

    /**
     * 练习2：栈溢出示例
     * 任务：理解StackOverflowError的发生场景
     */
    public static void practice2_StackOverflow() {
        System.out.println("\n=== 练习2：栈溢出 ===");
        
        // TODO: 创建一个会导致栈溢出的方法
        // 提示：无限递归调用
        
        // public static void recursiveMethod() {
        //     recursiveMethod();  // 无限递归
        // }
        
        // 注意：运行前请做好心理准备，会导致StackOverflowError
        // try {
        //     recursiveMethod();
        // } catch (StackOverflowError e) {
        //     System.out.println("栈溢出：" + e.getMessage());
        // }
    }

    /**
     * 练习3：堆内存溢出示例
     * 任务：理解OutOfMemoryError: Java heap space
     */
    public static void practice3_HeapOverflow() {
        System.out.println("\n=== 练习3：堆内存溢出 ===");
        
        // TODO: 创建一个会导致堆内存溢出的方法
        // 提示：创建大量对象
        
        // List<byte[]> list = new ArrayList<>();
        // while (true) {
        //     list.add(new byte[1024 * 1024]);  // 每次分配1MB
        // }
        
        // 注意：可以通过JVM参数 -Xmx 设置最大堆内存
        // 例如：-Xmx10m 设置最大堆内存为10MB
    }

    /**
     * 练习4：查看JVM内存使用情况
     * 任务：使用代码获取JVM内存信息
     */
    public static void practice4_MemoryInfo() {
        System.out.println("\n=== 练习4：JVM内存信息 ===");
        
        // TODO: 使用ManagementFactory获取JVM内存信息
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        
        // 获取堆内存信息
        System.out.println("最大堆内存: " + heapMemoryUsage.getMax() / 1024 / 1024 + " MB");
        System.out.println("已使用堆内存: " + heapMemoryUsage.getUsed() / 1024 / 1024 + " MB");
        System.out.println("初始堆内存: " + heapMemoryUsage.getInit() / 1024 / 1024 + " MB");
        System.out.println("已提交堆内存: " + heapMemoryUsage.getCommitted() / 1024 / 1024 + " MB");
        
        // TODO: 获取非堆内存（方法区/元空间）信息
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("\n非堆内存使用: " + nonHeapMemoryUsage.getUsed() / 1024 / 1024 + " MB");
        System.out.println("非堆内存最大: " + nonHeapMemoryUsage.getMax() / 1024 / 1024 + " MB");
        
        // TODO: 获取JVM运行时参数
        // RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        // List<String> jvmArgs = runtimeMXBean.getInputArguments();
        // System.out.println("JVM参数: " + jvmArgs);
    }

    /**
     * 练习5：垃圾回收算法理解
     * 任务：了解常见的GC算法
     */
    public static void practice5_GarbageCollectionAlgorithms() {
        System.out.println("\n=== 练习5：垃圾回收算法 ===");
        
        // TODO: 了解以下GC算法
        // 1. 标记-清除算法（Mark-Sweep）
        //    - 标记所有需要回收的对象
        //    - 清除被标记的对象
        //    - 缺点：产生内存碎片
        
        // 2. 复制算法（Copying）
        //    - 将内存分为两块，每次使用一块
        //    - 将存活对象复制到另一块，清除当前块
        //    - 适用于新生代（Eden和Survivor）
        
        // 3. 标记-整理算法（Mark-Compact）
        //    - 标记所有需要回收的对象
        //    - 将存活对象向一端移动
        //    - 清除边界外的内存
        //    - 适用于老年代
        
        // 4. 分代收集算法（Generational Collection）
        //    - 根据对象存活周期将内存分为新生代和老年代
        //    - 新生代使用复制算法
        //    - 老年代使用标记-清除或标记-整理算法
        
        System.out.println("请阅读注释，理解各种GC算法的特点");
    }

    /**
     * 练习6：垃圾收集器理解
     * 任务：了解常见的GC收集器
     */
    public static void practice6_GarbageCollectors() {
        System.out.println("\n=== 练习6：垃圾收集器 ===");
        
        // TODO: 了解以下垃圾收集器
        // 1. Serial收集器
        //    - 单线程，Stop The World
        //    - 适合客户端应用，新生代和老年代都使用
        
        // 2. ParNew收集器
        //    - Serial的多线程版本
        //    - 主要用于新生代
        
        // 3. Parallel Scavenge收集器
        //    - 关注吞吐量（吞吐量 = 运行用户代码时间 / (运行用户代码时间 + GC时间)）
        //    - 新生代收集器
        
        // 4. Parallel Old收集器
        //    - Parallel Scavenge的老年代版本
        
        // 5. CMS收集器（Concurrent Mark Sweep）
        //    - 并发标记清除
        //    - 以获取最短回收停顿时间为目标
        //    - 适合服务器应用
        
        // 6. G1收集器（Garbage First）
        //    - 面向服务端的垃圾收集器
        //    - 可预测的停顿时间模型
        //    - 适合大内存（6GB以上）应用
        
        // 7. ZGC收集器
        //    - 低延迟垃圾收集器
        //    - 适用于大堆内存
        
        System.out.println("请阅读注释，了解各种GC收集器的特点");
    }

    /**
     * 练习7：触发垃圾回收
     * 任务：使用System.gc()触发垃圾回收（注意：不保证立即执行）
     */
    public static void practice7_TriggerGC() {
        System.out.println("\n=== 练习7：触发GC ===");
        
        // TODO: 创建一些对象，然后尝试触发GC
        // 注意：System.gc()只是建议JVM进行垃圾回收，不保证立即执行
        
        // 创建大量对象
        // for (int i = 0; i < 1000; i++) {
        //     new Object();  // 创建后立即失去引用，可以回收
        // }
        
        // 建议垃圾回收（不保证立即执行）
        // System.gc();
        
        // 或者使用Runtime.getRuntime().gc()
        // Runtime.getRuntime().gc();
        
        System.out.println("System.gc()只是建议JVM进行垃圾回收");
    }

    /**
     * 练习8：类加载机制理解
     * 任务：了解类的加载过程
     */
    public static void practice8_ClassLoading() {
        System.out.println("\n=== 练习8：类加载机制 ===");
        
        // TODO: 了解类加载的5个阶段
        // 1. 加载（Loading）
        //    - 通过类的全限定名获取类的二进制字节流
        //    - 将字节流转换为方法区的运行时数据结构
        //    - 在内存中生成Class对象
        
        // 2. 验证（Verification）
        //    - 文件格式验证
        //    - 元数据验证
        //    - 字节码验证
        //    - 符号引用验证
        
        // 3. 准备（Preparation）
        //    - 为类变量分配内存并设置初始值（零值）
        //    - 注意：这里设置的是零值，不是代码中的初始值
        
        // 4. 解析（Resolution）
        //    - 将常量池中的符号引用替换为直接引用
        
        // 5. 初始化（Initialization）
        //    - 执行类构造器<clinit>()方法
        //    - 为类变量赋真正的初始值
        
        System.out.println("请阅读注释，理解类加载的5个阶段");
    }

    /**
     * 练习9：类加载器理解
     * 任务：了解Java的类加载器层次结构
     */
    public static void practice9_ClassLoaders() {
        System.out.println("\n=== 练习9：类加载器 ===");
        
        // TODO: 了解类加载器的层次结构
        // 1. 启动类加载器（Bootstrap ClassLoader）
        //    - 由C++实现，加载<JAVA_HOME>/lib下的核心类库
        //    - 无法直接获取
        
        // 2. 扩展类加载器（Extension ClassLoader）
        //    - 加载<JAVA_HOME>/lib/ext下的类库
        
        // 3. 应用程序类加载器（Application ClassLoader / System ClassLoader）
        //    - 加载classpath下的类
        //    - 最常用的类加载器
        
        // 4. 自定义类加载器
        //    - 继承ClassLoader类
        
        // 获取当前类的类加载器
        ClassLoader classLoader = JVMPractice.class.getClassLoader();
        System.out.println("当前类的类加载器: " + classLoader);
        
        // TODO: 打印类加载器的层次结构
        // ClassLoader parent = classLoader;
        // while (parent != null) {
        //     System.out.println("父类加载器: " + parent);
        //     parent = parent.getParent();
        // }
    }

    /**
     * 练习10：自定义类加载器
     * 任务：创建一个自定义类加载器
     */
    public static void practice10_CustomClassLoader() {
        System.out.println("\n=== 练习10：自定义类加载器 ===");
        
        // TODO: 创建一个自定义类加载器
        // class MyClassLoader extends ClassLoader {
        //     @Override
        //     protected Class<?> findClass(String name) throws ClassNotFoundException {
        //         // 1. 读取.class文件
        //         // 2. 转换为字节数组
        //         // 3. 调用defineClass()定义类
        //         return defineClass(name, bytes, 0, bytes.length);
        //     }
        // }
        
        System.out.println("请实现自定义类加载器");
    }

    /**
     * 练习11：JVM调优参数
     * 任务：了解常用的JVM调优参数
     */
    public static void practice11_JVMTuningParameters() {
        System.out.println("\n=== 练习11：JVM调优参数 ===");
        
        // TODO: 了解以下常用JVM参数
        // 堆内存相关：
        // -Xms: 初始堆内存大小
        // -Xmx: 最大堆内存大小
        // -Xmn: 新生代大小
        // -XX:NewRatio: 老年代与新生代的比例
        // -XX:SurvivorRatio: Eden区与Survivor区的比例
        
        // GC相关：
        // -XX:+UseSerialGC: 使用Serial收集器
        // -XX:+UseParallelGC: 使用Parallel收集器
        // -XX:+UseConcMarkSweepGC: 使用CMS收集器
        // -XX:+UseG1GC: 使用G1收集器
        // -XX:MaxGCPauseMillis: 最大GC停顿时间
        // -XX:GCTimeRatio: GC时间占比
        
        // 方法区/元空间相关：
        // -XX:PermSize: 永久代初始大小（Java 8之前）
        // -XX:MaxPermSize: 永久代最大大小（Java 8之前）
        // -XX:MetaspaceSize: 元空间初始大小（Java 8+）
        // -XX:MaxMetaspaceSize: 元空间最大大小（Java 8+）
        
        // 其他：
        // -XX:+PrintGCDetails: 打印GC详细信息
        // -XX:+HeapDumpOnOutOfMemoryError: OOM时生成堆转储文件
        // -Xss: 线程栈大小
        
        System.out.println("请阅读注释，了解常用JVM调优参数");
        
        // 获取当前JVM参数
        // RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        // List<String> jvmArgs = runtimeMXBean.getInputArguments();
        // System.out.println("当前JVM参数: " + jvmArgs);
    }

    /**
     * 练习12：对象生命周期理解
     * 任务：理解对象在堆中的生命周期
     */
    public static void practice12_ObjectLifecycle() {
        System.out.println("\n=== 练习12：对象生命周期 ===");
        
        // TODO: 理解对象在堆中的分配和回收过程
        // 1. 对象优先在Eden区分配
        //    - 大多数情况下，对象在新生代Eden区分配
        //    - 当Eden区没有足够空间时，触发Minor GC
        
        // 2. 大对象直接进入老年代
        //    - 大对象是指需要大量连续内存空间的Java对象（如很长的字符串、数组）
        //    - 可以通过-XX:PretenureSizeThreshold参数设置阈值
        
        // 3. 长期存活的对象进入老年代
        //    - 对象在Survivor区每经过一次Minor GC，年龄就增加1
        //    - 当年龄达到一定程度（默认15）时，晋升到老年代
        //    - 可以通过-XX:MaxTenuringThreshold参数设置
        
        // 4. 动态对象年龄判定
        //    - 如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半
        //    - 年龄大于或等于该年龄的对象可以直接进入老年代
        
        // 5. 空间分配担保
        //    - 在发生Minor GC之前，检查老年代最大可用连续空间是否大于新生代所有对象总空间
        //    - 如果大于，则Minor GC是安全的
        //    - 如果小于，则查看-XX:HandlePromotionFailure参数是否允许担保失败
        
        System.out.println("请阅读注释，理解对象在堆中的生命周期");
    }

    /**
     * 练习13：内存泄漏分析
     * 任务：理解内存泄漏的原因和检测方法
     */
    public static void practice13_MemoryLeak() {
        System.out.println("\n=== 练习13：内存泄漏 ===");
        
        // TODO: 了解内存泄漏的常见场景
        // 1. 集合类持有对象引用
        //    - 集合对象不使用时没有清空
        //    - 解决：及时调用clear()方法
        
        // 2. 监听器和回调
        //    - 注册了监听器但没有注销
        //    - 解决：及时移除监听器
        
        // 3. 内部类持有外部类引用
        //    - 内部类持有外部类的引用，导致外部类无法回收
        //    - 解决：使用静态内部类或弱引用
        
        // 4. ThreadLocal使用不当
        //    - ThreadLocal变量没有调用remove()
        //    - 解决：使用完后调用remove()
        
        // 检测工具：
        // - jmap: 生成堆转储文件
        // - jvisualvm: 可视化分析工具
        // - Eclipse MAT: 内存分析工具
        
        System.out.println("请阅读注释，了解内存泄漏的常见场景");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_MemoryAreas();
        practice2_StackOverflow();
        practice3_HeapOverflow();
        practice4_MemoryInfo();
        practice5_GarbageCollectionAlgorithms();
        practice6_GarbageCollectors();
        practice7_TriggerGC();
        practice8_ClassLoading();
        practice9_ClassLoaders();
        practice10_CustomClassLoader();
        practice11_JVMTuningParameters();
        practice12_ObjectLifecycle();
        practice13_MemoryLeak();
    }
}

