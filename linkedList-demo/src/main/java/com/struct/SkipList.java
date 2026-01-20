package com.struct;

import java.util.Random;

/**
 * 跳表（Skip List）实现
 * 
 * <p><strong>跳表是什么？</strong>
 * <p>跳表是一种概率性的数据结构，它是对有序链表的改进，通过添加多层索引来实现快速查找。
 * 跳表允许快速搜索、插入和删除操作，平均时间复杂度为 O(log n)。
 * 
 * <p><strong>工作原理：</strong>
 * <ul>
 *   <li>跳表由多层有序链表组成</li>
 *   <li>底层（第0层）包含所有元素，按顺序排列</li>
 *   <li>上层是下层的"快速通道"，每层大约包含下一层一半的元素</li>
 *   <li>查找时从顶层开始，逐层向下查找，可以快速跳过大量元素</li>
 * </ul>
 * 
 * <p><strong>特点：</strong>
 * <ul>
 *   <li>时间复杂度：查找、插入、删除平均 O(log n)，最坏 O(n)</li>
 *   <li>空间复杂度：O(n)，因为需要存储多层索引</li>
 *   <li>实现简单：比平衡树（如红黑树）更容易实现</li>
 *   <li>概率性：通过随机决定节点层数，保持平衡</li>
 * </ul>
 * 
 * <p><strong>应用场景：</strong>
 * <ul>
 *   <li>Redis 的有序集合（Sorted Set）底层实现</li>
 *   <li>需要快速查找的有序数据结构</li>
 *   <li>替代平衡树的简单方案</li>
 * </ul>
 * 
 * @author Your Name
 * @version 1.0
 */
public class SkipList {
    
    /**
     * 跳表节点
     */
    private static class SkipListNode {
        int value;                    // 节点值
        SkipListNode[] forward;       // 每层的下一个节点指针数组
        
        public SkipListNode(int value, int level) {
            this.value = value;
            this.forward = new SkipListNode[level + 1];  // level从0开始，所以需要+1
        }
    }
    
    // 最大层数（通常设为 log2(n)，这里设为16足够大）
    private static final int MAX_LEVEL = 16;
    
    // 概率因子（决定节点出现在第i层的概率为 0.5^i）
    private static final double P = 0.5;
    
    // 头节点（不存储实际数据，作为每层的起始点）
    private SkipListNode head;
    
    // 当前跳表的实际最大层数
    private int currentLevel;
    
    // 随机数生成器，用于决定新节点的层数
    private Random random;
    
    /**
     * 构造函数
     */
    public SkipList() {
        this.head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
        this.currentLevel = 0;
        this.random = new Random();
    }
    
    /**
     * 随机生成节点的层数
     * 使用概率 P = 0.5，即每个节点有50%的概率出现在下一层
     * 
     * @return 节点的层数（0到MAX_LEVEL之间）
     */
    private int randomLevel() {
        int level = 0;
        // 每次有50%的概率增加一层
        while (random.nextDouble() < P && level < MAX_LEVEL - 1) {
            level++;
        }
        return level;
    }
    
    /**
     * 查找元素
     * 
     * <p>查找过程：
     * 1. 从顶层开始，向右查找
     * 2. 如果当前层的下一个节点值大于目标值，则向下移动一层
     * 3. 如果当前层的下一个节点值小于等于目标值，则向右移动
     * 4. 重复直到找到目标值或到达底层
     * 
     * @param value 要查找的值
     * @return 如果找到返回true，否则返回false
     */
    public boolean search(int value) {
        SkipListNode current = head;
        
        // 从顶层向下查找
        for (int i = currentLevel; i >= 0; i--) {
            // 在当前层向右查找，直到下一个节点值大于目标值
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }
        
        // 移动到目标节点（如果存在）
        current = current.forward[0];
        
        // 检查是否找到目标值
        return current != null && current.value == value;
    }
    
    /**
     * 插入元素
     * 
     * <p>插入过程：
     * 1. 查找插入位置（记录每层需要更新的节点）
     * 2. 随机生成新节点的层数
     * 3. 创建新节点
     * 4. 更新各层的指针
     * 
     * @param value 要插入的值
     */
    public void insert(int value) {
        // update数组记录每层需要更新的节点（即新节点应该插入在这些节点之后）
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;
        
        // 从顶层向下查找插入位置
        for (int i = currentLevel; i >= 0; i--) {
            // 在当前层向右查找，直到下一个节点值大于等于目标值
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            // 记录当前层需要更新的节点
            update[i] = current;
        }
        
        // 移动到应该插入的位置
        current = current.forward[0];
        
        // 如果值已存在，可以选择不插入或更新（这里选择不插入重复值）
        if (current != null && current.value == value) {
            System.out.println("值 " + value + " 已存在，跳过插入");
            return;
        }
        
        // 随机生成新节点的层数
        int newLevel = randomLevel();
        
        // 如果新节点的层数大于当前最大层数，需要更新头节点的指针
        if (newLevel > currentLevel) {
            for (int i = currentLevel + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            currentLevel = newLevel;
        }
        
        // 创建新节点
        SkipListNode newNode = new SkipListNode(value, newLevel);
        
        // 更新各层的指针
        for (int i = 0; i <= newLevel; i++) {
            // 新节点的forward指向update[i]原来的forward
            newNode.forward[i] = update[i].forward[i];
            // update[i]的forward指向新节点
            update[i].forward[i] = newNode;
        }
    }
    
    /**
     * 删除元素
     * 
     * <p>删除过程：
     * 1. 查找要删除的节点（记录每层需要更新的节点）
     * 2. 如果找到，更新各层的指针
     * 3. 如果删除后某些层变为空，降低当前层数
     * 
     * @param value 要删除的值
     * @return 如果找到并删除返回true，否则返回false
     */
    public boolean delete(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;
        
        // 从顶层向下查找要删除的节点
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        
        // 移动到要删除的节点
        current = current.forward[0];
        
        // 如果节点不存在，返回false
        if (current == null || current.value != value) {
            return false;
        }
        
        // 更新各层的指针，跳过要删除的节点
        for (int i = 0; i <= currentLevel; i++) {
            // 如果update[i]的forward[i]不是要删除的节点，说明该层不需要更新
            if (update[i].forward[i] != current) {
                break;
            }
            // 跳过要删除的节点
            update[i].forward[i] = current.forward[i];
        }
        
        // 如果删除后某些层变为空，降低当前层数
        while (currentLevel > 0 && head.forward[currentLevel] == null) {
            currentLevel--;
        }
        
        return true;
    }
    
    /**
     * 打印跳表结构（用于调试和可视化）
     */
    public void print() {
        System.out.println("========== 跳表结构 ==========");
        // 从顶层向下打印
        for (int i = currentLevel; i >= 0; i--) {
            System.out.print("Level " + i + ": ");
            SkipListNode current = head.forward[i];
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.forward[i];
            }
            System.out.println("null");
        }
        System.out.println("=============================");
    }
    
    /**
     * 打印跳表的所有元素（按顺序）
     */
    public void printAll() {
        System.out.print("所有元素（按顺序）: ");
        SkipListNode current = head.forward[0];
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.forward[0];
        }
        System.out.println();
    }
    
    /**
     * 获取跳表中元素的数量
     * 
     * @return 元素数量
     */
    public int size() {
        int count = 0;
        SkipListNode current = head.forward[0];
        while (current != null) {
            count++;
            current = current.forward[0];
        }
        return count;
    }
    
    /**
     * 判断跳表是否为空
     * 
     * @return 如果为空返回true，否则返回false
     */
    public boolean isEmpty() {
        return head.forward[0] == null;
    }
    
    /**
     * 测试主方法
     */
    public static void main(String[] args) {
        System.out.println("========== 跳表（Skip List）演示 ==========\n");
        
        SkipList skipList = new SkipList();
        
        // 测试插入
        System.out.println("1. 插入元素: 3, 6, 7, 9, 12, 19, 17, 26, 21, 25");
        int[] values = {3, 6, 7, 9, 12, 19, 17, 26, 21, 25};
        for (int value : values) {
            skipList.insert(value);
        }
        
        skipList.print();
        skipList.printAll();
        System.out.println("元素数量: " + skipList.size());
        System.out.println();
        
        // 测试查找
        System.out.println("2. 查找元素:");
        System.out.println("查找 7: " + skipList.search(7));   // 应该返回 true
        System.out.println("查找 10: " + skipList.search(10));  // 应该返回 false
        System.out.println("查找 25: " + skipList.search(25));  // 应该返回 true
        System.out.println();
        
        // 测试删除
        System.out.println("3. 删除元素 7:");
        boolean deleted = skipList.delete(7);
        System.out.println("删除结果: " + deleted);
        skipList.print();
        skipList.printAll();
        System.out.println();
        
        System.out.println("4. 删除元素 10 (不存在):");
        deleted = skipList.delete(10);
        System.out.println("删除结果: " + deleted);
        System.out.println();
        
        // 测试插入重复值
        System.out.println("5. 尝试插入重复值 9:");
        skipList.insert(9);
        skipList.printAll();
        System.out.println();
        
        // 测试边界情况
        System.out.println("6. 测试边界情况:");
        SkipList emptyList = new SkipList();
        System.out.println("空跳表是否为空: " + emptyList.isEmpty());
        System.out.println("空跳表大小: " + emptyList.size());
        System.out.println("在空跳表中查找 5: " + emptyList.search(5));
        System.out.println("从空跳表中删除 5: " + emptyList.delete(5));
        
        System.out.println("\n========== 演示结束 ==========");
    }
}

