package com.struct.practice;

import java.util.*;

/**
 * 树结构练习
 * 练习内容：
 * 1. 二叉树（遍历、查找、插入、删除）
 * 2. 二叉搜索树（BST）
 * 3. 平衡二叉树（AVL树）
 * 4. 堆（最大堆、最小堆）
 * 5. 哈夫曼树
 */
public class TreeStructurePractice {

    /**
     * 练习1：二叉树节点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 练习2：二叉树遍历
     * 任务：实现二叉树的四种遍历方式
     */
    public static class BinaryTreeTraversal {

        // TODO: 前序遍历（根-左-右）
        public static void preOrder(TreeNode root) {
            // 递归实现
            // 1. 访问根节点
            // 2. 递归遍历左子树
            // 3. 递归遍历右子树
        }

        // TODO: 前序遍历（非递归）
        public static List<Integer> preOrderIterative(TreeNode root) {
            // 使用栈实现
            // 1. 将根节点入栈
            // 2. 当栈不为空时：
            //    - 弹出栈顶节点并访问
            //    - 先将右子节点入栈，再将左子节点入栈
            return new ArrayList<>();
        }

        // TODO: 中序遍历（左-根-右）
        public static void inOrder(TreeNode root) {
            // 递归实现
            // 1. 递归遍历左子树
            // 2. 访问根节点
            // 3. 递归遍历右子树
        }

        // TODO: 中序遍历（非递归）
        public static List<Integer> inOrderIterative(TreeNode root) {
            // 使用栈实现
            // 1. 从根节点开始，将所有左子节点入栈
            // 2. 弹出栈顶节点并访问
            // 3. 将当前节点设为右子节点，重复步骤1
            return new ArrayList<>();
        }

        // TODO: 后序遍历（左-右-根）
        public static void postOrder(TreeNode root) {
            // 递归实现
            // 1. 递归遍历左子树
            // 2. 递归遍历右子树
            // 3. 访问根节点
        }

        // TODO: 后序遍历（非递归）
        public static List<Integer> postOrderIterative(TreeNode root) {
            // 使用两个栈实现
            // 1. 将根节点入栈1
            // 2. 当栈1不为空时：
            //    - 弹出节点并压入栈2
            //    - 将左子节点和右子节点依次压入栈1
            // 3. 依次弹出栈2的节点并访问
            return new ArrayList<>();
        }

        // TODO: 层序遍历（广度优先）
        public static List<Integer> levelOrder(TreeNode root) {
            // 使用队列实现
            // 1. 将根节点入队
            // 2. 当队列不为空时：
            //    - 出队一个节点并访问
            //    - 将左子节点和右子节点依次入队
            return new ArrayList<>();
        }
    }

    /**
     * 练习3：二叉搜索树（BST）
     * 任务：实现BST的增删改查
     */
    public static class BinarySearchTree {
        private TreeNode root;

        public BinarySearchTree() {
            this.root = null;
        }

        // TODO: 插入节点
        public void insert(int val) {
            root = insertRecursive(root, val);
        }

        private TreeNode insertRecursive(TreeNode root, int val) {
            // 如果树为空，创建新节点
            // 如果val < root.val，递归插入左子树
            // 如果val > root.val，递归插入右子树
            // 返回根节点
            return null;
        }

        // TODO: 查找节点
        public TreeNode search(int val) {
            return searchRecursive(root, val);
        }

        private TreeNode searchRecursive(TreeNode root, int val) {
            // 如果root为null或root.val == val，返回root
            // 如果val < root.val，递归查找左子树
            // 否则递归查找右子树
            return null;
        }

        // TODO: 删除节点
        public void delete(int val) {
            root = deleteRecursive(root, val);
        }

        private TreeNode deleteRecursive(TreeNode root, int val) {
            // 如果root为null，返回null
            // 如果val < root.val，递归删除左子树
            // 如果val > root.val，递归删除右子树
            // 如果val == root.val：
            //    - 如果节点没有子节点，返回null
            //    - 如果节点只有一个子节点，返回该子节点
            //    - 如果节点有两个子节点：
            //      * 找到右子树的最小值节点
            //      * 用最小值替换当前节点
            //      * 删除右子树的最小值节点
            return null;
        }

        // TODO: 查找最小值节点
        private TreeNode findMin(TreeNode root) {
            // 一直向左查找，直到没有左子节点
            return null;
        }

        // TODO: 验证BST
        public boolean isValidBST() {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long min, long max) {
            // 如果root为null，返回true
            // 如果root.val不在(min, max)范围内，返回false
            // 递归验证左子树和右子树
            return false;
        }
    }

    /**
     * 练习4：堆（最大堆）
     * 任务：使用数组实现最大堆
     */
    public static class MaxHeap {
        private List<Integer> heap;

        public MaxHeap() {
            this.heap = new ArrayList<>();
        }

        // TODO: 插入元素
        public void insert(int val) {
            // 将元素添加到数组末尾
            // 向上调整（heapify up）
            // 比较当前节点和父节点，如果当前节点更大则交换
        }

        // TODO: 删除最大值
        public int extractMax() {
            // 如果堆为空，抛出异常
            // 保存根节点的值
            // 将最后一个元素移到根节点
            // 删除最后一个元素
            // 向下调整（heapify down）
            // 返回保存的值
            return 0;
        }

        // TODO: 向上调整
        private void heapifyUp(int index) {
            // 当index > 0时：
            // 计算父节点索引 parent = (index - 1) / 2
            // 如果heap[index] > heap[parent]，交换并继续向上
        }

        // TODO: 向下调整
        private void heapifyDown(int index) {
            // 计算左右子节点索引
            // 找到最大值所在的索引
            // 如果最大值不是当前节点，交换并继续向下
        }

        // TODO: 获取最大值（不删除）
        public int peek() {
            // 如果堆为空，抛出异常
            // 返回heap[0]
            return 0;
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heap.size();
        }
    }

    /**
     * 练习5：最小堆
     * 任务：实现最小堆
     */
    public static class MinHeap {
        private List<Integer> heap;

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        // TODO: 插入元素
        public void insert(int val) {
            // 类似最大堆，但比较时使用小于号
        }

        // TODO: 删除最小值
        public int extractMin() {
            // 类似最大堆，但调整时找最小值
            return 0;
        }

        // TODO: 获取最小值
        public int peek() {
            return 0;
        }
    }

    /**
     * 练习6：二叉树的最大深度
     * 任务：计算二叉树的最大深度
     */
    public static int maxDepth(TreeNode root) {
        // 如果root为null，返回0
        // 递归计算左子树和右子树的最大深度
        // 返回较大值 + 1
        return 0;
    }

    /**
     * 练习7：判断是否为平衡二叉树
     * 任务：判断二叉树是否为平衡二叉树
     */
    public static boolean isBalanced(TreeNode root) {
        // 平衡二叉树：每个节点的左右子树高度差不超过1
        // 递归判断每个节点
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {
        // 如果root为null，返回0
        // 递归计算左子树和右子树的高度
        // 如果高度差大于1，返回-1（表示不平衡）
        // 否则返回最大高度 + 1
        return 0;
    }

    /**
     * 练习8：二叉树的最近公共祖先
     * 任务：找到两个节点的最近公共祖先
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为null或root等于p或q，返回root
        // 递归查找左子树和右子树
        // 如果左右子树都找到，返回root
        // 如果只在一侧找到，返回该侧的结果
        return null;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 树结构练习 ===");
        
        // 创建测试树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // 测试遍历
        System.out.println("前序遍历:");
        BinaryTreeTraversal.preOrder(root);
        
        System.out.println("\n中序遍历:");
        BinaryTreeTraversal.inOrder(root);
        
        System.out.println("\n后序遍历:");
        BinaryTreeTraversal.postOrder(root);
        
        System.out.println("\n层序遍历:");
        List<Integer> levelOrder = BinaryTreeTraversal.levelOrder(root);
        System.out.println(levelOrder);
        
        // 测试BST
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        
        // 测试堆
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        System.out.println("堆的最大值: " + maxHeap.peek());
    }
}

