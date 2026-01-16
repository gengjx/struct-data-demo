package com.struct.practice;

/**
 * Java进阶练习主入口
 * 按照学习路线顺序运行各个练习模块
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    Java进阶阶段学习练习代码");
        System.out.println("========================================\n");

        System.out.println("请根据学习进度，选择相应的练习类进行学习：\n");

        System.out.println("【第一部分：JVM深入】");
        System.out.println("1. JVMPractice - JVM深入练习");
        System.out.println("   - JVM内存模型（堆、栈、方法区）");
        System.out.println("   - 垃圾回收机制（GC算法、GC收集器）");
        System.out.println("   - 类加载机制（加载、验证、准备、解析、初始化）");
        System.out.println("   - JVM调优参数和工具使用");
        System.out.println();

        System.out.println("【第二部分：并发编程深入】");
        System.out.println("2. ConcurrentProgrammingPractice - 并发编程深入练习");
        System.out.println("   - volatile关键字的深入理解");
        System.out.println("   - synchronized的底层原理");
        System.out.println("   - CAS（Compare-And-Swap）机制");
        System.out.println("   - AQS（AbstractQueuedSynchronizer）框架");
        System.out.println("   - 线程池原理和实现");
        System.out.println("   - 并发集合的使用");
        System.out.println("   - Fork/Join框架");
        System.out.println();

        System.out.println("【第三部分：设计模式】");
        System.out.println("3. DesignPatternPractice - 设计模式练习");
        System.out.println("   - 创建型模式：单例、工厂、建造者");
        System.out.println("   - 结构型模式：代理、适配器、装饰器、组合");
        System.out.println("   - 行为型模式：观察者、策略、责任链、模板方法、状态、命令");
        System.out.println();

        System.out.println("========================================");
        System.out.println("学习方法：");
        System.out.println("1. 先学习理论知识，理解概念和原理");
        System.out.println("2. 阅读练习代码中的注释和示例");
        System.out.println("3. 完成TODO任务，实现相应的代码");
        System.out.println("4. 运行测试，验证实现是否正确");
        System.out.println("5. 深入理解实现原理，思考应用场景");
        System.out.println("========================================");
        System.out.println();
        System.out.println("提示：");
        System.out.println("- JVM部分建议配合《深入理解Java虚拟机》学习");
        System.out.println("- 并发编程部分建议阅读JDK源码");
        System.out.println("- 设计模式部分建议结合实际项目应用");
        System.out.println("========================================");
    }
}

