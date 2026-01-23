/**
 * 二叉树 - 数组实现
 * 使用数组存储二叉树节点，通过索引关系定位父子节点
 * - 根节点索引：1
 * - 左子节点索引：2 * parentIndex
 * - 右子节点索引：2 * parentIndex + 1
 * - 父节点索引：childIndex / 2
 */
public class BinaryTreeArray {
    private static final int DEFAULT_CAPACITY = 100;
    private Integer[] tree;  // 使用Integer数组，null表示空节点
    private int size;        // 树中节点的数量
    private int capacity;    // 数组容量

    public BinaryTreeArray() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryTreeArray(int capacity) {
        this.capacity = capacity;
        this.tree = new Integer[capacity];
        this.size = 0;
    }

    /**
     * 在指定位置插入节点
     * @param index 节点索引（从1开始）
     * @param data 节点数据
     * @return 是否插入成功
     */
    public boolean insert(int index, int data) {
        if (index < 1 || index >= capacity) {
            return false;
        }
        if (tree[index] != null) {
            return false; // 位置已被占用
        }
        tree[index] = data;
        size++;
        return true;
    }

    /**
     * 在根节点插入数据
     */
    public boolean insertRoot(int data) {
        return insert(1, data);
    }

    /**
     * 在指定节点的左子节点插入数据
     */
    public boolean insertLeft(int parentIndex, int data) {
        int leftIndex = 2 * parentIndex;
        return insert(leftIndex, data);
    }

    /**
     * 在指定节点的右子节点插入数据
     */
    public boolean insertRight(int parentIndex, int data) {
        int rightIndex = 2 * parentIndex + 1;
        return insert(rightIndex, data);
    }

    /**
     * 获取指定索引的节点值
     */
    public Integer get(int index) {
        if (index < 1 || index >= capacity) {
            return null;
        }
        return tree[index];
    }

    /**
     * 获取根节点值
     */
    public Integer getRoot() {
        return get(1);
    }

    /**
     * 获取左子节点值
     */
    public Integer getLeft(int parentIndex) {
        return get(2 * parentIndex);
    }

    /**
     * 获取右子节点值
     */
    public Integer getRight(int parentIndex) {
        return get(2 * parentIndex + 1);
    }

    /**
     * 获取父节点值
     */
    public Integer getParent(int childIndex) {
        if (childIndex <= 1) {
            return null; // 根节点没有父节点
        }
        return get(childIndex / 2);
    }

    /**
     * 删除指定位置的节点
     */
    public boolean delete(int index) {
        if (index < 1 || index >= capacity || tree[index] == null) {
            return false;
        }
        // 如果有子节点，不能直接删除
        if (hasLeftChild(index) || hasRightChild(index)) {
            return false;
        }
        tree[index] = null;
        size--;
        return true;
    }

    /**
     * 判断是否有左子节点
     */
    public boolean hasLeftChild(int index) {
        int leftIndex = 2 * index;
        return leftIndex < capacity && tree[leftIndex] != null;
    }

    /**
     * 判断是否有右子节点
     */
    public boolean hasRightChild(int index) {
        int rightIndex = 2 * index + 1;
        return rightIndex < capacity && tree[rightIndex] != null;
    }

    /**
     * 判断是否为叶子节点
     */
    public boolean isLeaf(int index) {
        return !hasLeftChild(index) && !hasRightChild(index);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(1);
        System.out.println();
    }

    private void preOrder(int index) {
        if (index >= capacity || tree[index] == null) {
            return;
        }
        System.out.print(tree[index] + " ");
        preOrder(2 * index);        // 左子树
        preOrder(2 * index + 1);    // 右子树
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(1);
        System.out.println();
    }

    private void inOrder(int index) {
        if (index >= capacity || tree[index] == null) {
            return;
        }
        inOrder(2 * index);         // 左子树
        System.out.print(tree[index] + " ");
        inOrder(2 * index + 1);      // 右子树
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(1);
        System.out.println();
    }

    private void postOrder(int index) {
        if (index >= capacity || tree[index] == null) {
            return;
        }
        postOrder(2 * index);       // 左子树
        postOrder(2 * index + 1);    // 右子树
        System.out.print(tree[index] + " ");
    }

    /**
     * 层序遍历（广度优先遍历）
     */
    public void levelOrder() {
        for (int i = 1; i < capacity; i++) {
            if (tree[i] != null) {
                System.out.print(tree[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * 获取树的大小
     */
    public int size() {
        return size;
    }

    /**
     * 判断树是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空树
     */
    public void clear() {
        for (int i = 1; i < capacity; i++) {
            tree[i] = null;
        }
        size = 0;
    }

    /**
     * 获取树的高度
     */
    public int height() {
        return height(1);
    }

    private int height(int index) {
        if (index >= capacity || tree[index] == null) {
            return 0;
        }
        int leftHeight = height(2 * index);
        int rightHeight = height(2 * index + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

