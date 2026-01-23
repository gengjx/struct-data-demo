/**
 * 二叉树测试类
 * 演示数组实现和链表实现的使用
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        System.out.println("========== 数组实现的二叉树 ==========");
        testArrayImplementation();

        System.out.println("\n========== 链表实现的二叉树 ==========");
        testLinkedListImplementation();
    }

    /**
     * 测试数组实现
     */
    private static void testArrayImplementation() {
        BinaryTreeArray tree = new BinaryTreeArray(50);

        // 构建树：
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        tree.insertRoot(1);
        tree.insertLeft(1, 2);
        tree.insertRight(1, 3);
        tree.insertLeft(2, 4);
        tree.insertRight(2, 5);
        tree.insertRight(3, 6);

        System.out.println("树的大小: " + tree.size());
        System.out.println("树的高度: " + tree.height());
        System.out.println("根节点: " + tree.getRoot());
        System.out.println("节点2的左子节点: " + tree.getLeft(2));
        System.out.println("节点2的右子节点: " + tree.getRight(2));

        System.out.print("前序遍历: ");
        tree.preOrder();

        System.out.print("中序遍历: ");
        tree.inOrder();

        System.out.print("后序遍历: ");
        tree.postOrder();

        System.out.print("层序遍历: ");
        tree.levelOrder();
    }

    /**
     * 测试链表实现
     */
    private static void testLinkedListImplementation() {
        BinaryTreeLinkedList tree = new BinaryTreeLinkedList();

        // 构建树：
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        tree.setRoot(1);
        BinaryTreeLinkedList.Node root = tree.getRoot();
        tree.insertLeft(root, 2);
        tree.insertRight(root, 3);

        BinaryTreeLinkedList.Node node2 = root.left;
        tree.insertLeft(node2, 4);
        tree.insertRight(node2, 5);

        BinaryTreeLinkedList.Node node3 = root.right;
        tree.insertRight(node3, 6);

        System.out.println("树的大小: " + tree.size());
        System.out.println("树的高度: " + tree.height());
        System.out.println("根节点: " + tree.getRoot().getData());
        System.out.println("节点2的左子节点: " + (node2.left != null ? node2.left.getData() : "null"));
        System.out.println("节点2的右子节点: " + (node2.right != null ? node2.right.getData() : "null"));

        System.out.print("前序遍历: ");
        tree.preOrder();

        System.out.print("中序遍历: ");
        tree.inOrder();

        System.out.print("后序遍历: ");
        tree.postOrder();

        System.out.print("层序遍历: ");
        tree.levelOrder();

        // 测试查找
        BinaryTreeLinkedList.Node found = tree.find(5);
        System.out.println("查找节点5: " + (found != null ? "找到，值为" + found.getData() : "未找到"));
    }
}

