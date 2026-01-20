package com.struct.practice;

import java.sql.*;
import java.util.Properties;

/**
 * 数据库练习
 * 练习内容：
 * 1. JDBC基础操作
 * 2. MySQL索引优化
 * 3. 事务和锁机制
 * 4. SQL优化
 * 5. 数据库设计原则
 */
public class DatabasePractice {

    /**
     * 练习1：JDBC基础操作
     * 任务：掌握JDBC的基本使用
     */
    public static void practice1_JDBCBasics() {
        System.out.println("=== 练习1：JDBC基础 ===");
        
        // TODO: 使用JDBC连接数据库并执行SQL
        // 1. 加载数据库驱动
        //    Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2. 获取数据库连接
        //    String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        //    String username = "root";
        //    String password = "password";
        //    Connection conn = DriverManager.getConnection(url, username, password);
        
        // 3. 创建Statement或PreparedStatement
        //    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        //    pstmt.setLong(1, 1L);
        
        // 4. 执行SQL语句
        //    ResultSet rs = pstmt.executeQuery();
        //    while (rs.next()) {
        //        Long id = rs.getLong("id");
        //        String name = rs.getString("name");
        //        System.out.println("ID: " + id + ", Name: " + name);
        //    }
        
        // 5. 关闭资源
        //    rs.close();
        //    pstmt.close();
        //    conn.close();
        
        // 注意：使用try-with-resources自动关闭资源
        
        System.out.println("请实现JDBC基本操作");
    }

    /**
     * 练习2：MySQL索引理解
     * 任务：理解索引的类型和使用场景
     */
    public static void practice2_MySQLIndexes() {
        System.out.println("\n=== 练习2：MySQL索引 ===");
        
        // TODO: 理解MySQL索引
        // 1. 索引类型
        //    - 主键索引（PRIMARY KEY）
        //    - 唯一索引（UNIQUE）
        //    - 普通索引（INDEX）
        //    - 全文索引（FULLTEXT）
        //    - 组合索引（多列索引）
        
        // 2. 索引数据结构
        //    - B+树索引（最常用）
        //    - Hash索引（Memory引擎）
        //    - 全文索引（MyISAM引擎）
        
        // 3. 创建索引
        //    CREATE INDEX idx_name ON users(name);
        //    CREATE INDEX idx_name_age ON users(name, age);  // 组合索引
        
        // 4. 索引使用原则
        //    - 经常查询的列
        //    - 经常用于WHERE条件的列
        //    - 经常用于JOIN的列
        //    - 不要在小表上创建索引
        //    - 不要在频繁更新的列上创建索引
        
        // 5. 索引优化
        //    - 使用EXPLAIN分析SQL执行计划
        //    - 避免在索引列上使用函数
        //    - 遵循最左前缀原则（组合索引）
        
        System.out.println("请理解MySQL索引的类型和使用场景");
    }

    /**
     * 练习3：事务的理解
     * 任务：理解ACID特性和事务隔离级别
     */
    public static void practice3_Transaction() {
        System.out.println("\n=== 练习3：事务 ===");
        
        // TODO: 理解事务的ACID特性
        // 1. 原子性（Atomicity）
        //    - 事务是一个不可分割的工作单位，要么全部执行，要么全部不执行
        
        // 2. 一致性（Consistency）
        //    - 事务执行前后，数据库从一个一致状态转换到另一个一致状态
        
        // 3. 隔离性（Isolation）
        //    - 并发事务之间相互隔离，不能相互干扰
        
        // 4. 持久性（Durability）
        //    - 事务一旦提交，对数据库的改变是永久的
        
        // TODO: 理解事务隔离级别
        // 1. READ UNCOMMITTED（读未提交）
        //    - 最低隔离级别，可能出现脏读、不可重复读、幻读
        
        // 2. READ COMMITTED（读已提交）
        //    - 避免脏读，可能出现不可重复读、幻读（MySQL默认）
        
        // 3. REPEATABLE READ（可重复读）
        //    - 避免脏读、不可重复读，可能出现幻读（MySQL InnoDB默认）
        
        // 4. SERIALIZABLE（串行化）
        //    - 最高隔离级别，避免所有问题，但性能最低
        
        // 设置隔离级别：
        // SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
        
        System.out.println("请理解事务的ACID特性和隔离级别");
    }

    /**
     * 练习4：锁机制理解
     * 任务：理解MySQL的锁机制
     */
    public static void practice4_LockMechanism() {
        System.out.println("\n=== 练习4：锁机制 ===");
        
        // TODO: 理解MySQL的锁机制
        // 1. 锁的类型
        //    - 共享锁（Shared Lock，S锁，读锁）
        //    - 排他锁（Exclusive Lock，X锁，写锁）
        
        // 2. 锁的粒度
        //    - 表锁：锁定整张表
        //    - 行锁：锁定一行数据（InnoDB支持）
        //    - 页锁：锁定一页数据
        
        // 3. 行锁的实现
        //    - Record Lock：记录锁，锁定具体行
        //    - Gap Lock：间隙锁，锁定一个范围，但不包括记录本身
        //    - Next-Key Lock：记录锁+间隙锁
        
        // 4. 锁的使用
        //    - SELECT ... FOR UPDATE;  // 加排他锁
        //    - SELECT ... LOCK IN SHARE MODE;  // 加共享锁
        
        // 5. 死锁
        //    - 两个或多个事务互相等待对方释放锁
        //    - InnoDB会自动检测死锁并回滚其中一个事务
        
        System.out.println("请理解MySQL的锁机制");
    }

    /**
     * 练习5：SQL优化
     * 任务：掌握SQL优化的方法
     */
    public static void practice5_SQLOptimization() {
        System.out.println("\n=== 练习5：SQL优化 ===");
        
        // TODO: 掌握SQL优化方法
        // 1. 使用EXPLAIN分析SQL
        //    EXPLAIN SELECT * FROM users WHERE name = 'John';
        
        // 2. 避免SELECT *
        //    只查询需要的列
        
        // 3. 使用索引
        //    在WHERE、JOIN、ORDER BY的列上创建索引
        
        // 4. 避免在WHERE子句中使用函数
        //    错误：WHERE YEAR(create_time) = 2024
        //    正确：WHERE create_time >= '2024-01-01' AND create_time < '2025-01-01'
        
        // 5. 使用LIMIT限制返回结果
        //    SELECT * FROM users LIMIT 10;
        
        // 6. 使用JOIN代替子查询（在大多数情况下）
        
        // 7. 避免使用OR（可以用UNION代替）
        //    错误：WHERE id = 1 OR id = 2
        //    正确：WHERE id = 1 UNION SELECT * FROM users WHERE id = 2
        
        // 8. 使用EXISTS代替IN（当子查询结果集较大时）
        
        // 9. 使用批量插入
        //    INSERT INTO users (name, age) VALUES ('John', 20), ('Jane', 21);
        
        System.out.println("请掌握SQL优化方法");
    }

    /**
     * 练习6：数据库设计原则
     * 任务：理解数据库设计的基本原则
     */
    public static void practice6_DatabaseDesign() {
        System.out.println("\n=== 练习6：数据库设计 ===");
        
        // TODO: 理解数据库设计原则
        // 1. 范式设计
        //    - 第一范式（1NF）：每个字段都是原子值，不可再分
        //    - 第二范式（2NF）：在1NF基础上，非主键字段完全依赖于主键
        //    - 第三范式（3NF）：在2NF基础上，非主键字段不依赖于其他非主键字段
        
        // 2. 表设计原则
        //    - 选择合适的数据类型
        //    - 使用NOT NULL约束
        //    - 为表添加合适的索引
        //    - 合理设计主键和外键
        
        // 3. 关系设计
        //    - 一对一（1:1）
        //    - 一对多（1:N）
        //    - 多对多（M:N，需要中间表）
        
        // 4. 命名规范
        //    - 表名：小写，多个单词用下划线分隔（users, user_profiles）
        //    - 字段名：小写，多个单词用下划线分隔（user_name, create_time）
        //    - 索引名：idx_表名_字段名（idx_users_name）
        
        System.out.println("请理解数据库设计原则");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_JDBCBasics();
        practice2_MySQLIndexes();
        practice3_Transaction();
        practice4_LockMechanism();
        practice5_SQLOptimization();
        practice6_DatabaseDesign();
    }
}








