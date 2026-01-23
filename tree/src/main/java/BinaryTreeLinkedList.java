import lombok.Getter;
import org.w3c.dom.Node;


@Getter
public class BinaryTreeLinkedList {

    private Node root;

    public BinaryTreeLinkedList() {
        this.root = null;
    }


    public void setRoot(int value) {
        this.root = new Node(value);
    }

    public boolean insertLeft(Node parent, int data) {
        if (parent == null) {
            return false;
        }
        if (parent.left != null) {
            return false;
        }
        parent.left = new Node(data);
        return true;
    }

    public boolean insertRight(Node parent, int data) {
        if (parent == null) {
            return false;
        }
        if (parent.right != null) {
            return false;
        }
        parent.right = new Node(data);
        return true;
    }

    public boolean delete(Node node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return false;
        }
        Node parent = findParent(root, node);
        if (parent == null) {
            root = null;
        } else if (parent.left == node){
            parent.left = null;
        }else{
            parent.right = null;
        }
        return true;
    }

    public Node findParent(Node current, Node target){
        if (current == null || current == target) {
            return null;
        }
        if (current.left == target || current.right == target) {
            return current;
        }
        Node leftResult = findParent(current.left, target);
        if (leftResult != null) {
            return leftResult;
        }
        return findParent(current.right, target);
    }

    public Node find(int data){
       return find(root, data);
    }

    public Node find(Node node, int data){
        if (node == null) {
            return null;
        }
        if(node.data == data){
            return node;
        }
        Node leftResult = find(node.left, data);
        if (leftResult != null) {
            return leftResult;
        }
        return find(node.right, data);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println();
            return;
        }
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 获取树的大小
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    /**
     * 判断树是否为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 获取树的高度
     */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 判断是否为叶子节点
     */
    public boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    /**
     * 清空树
     */
    public void clear() {
        root = null;
    }







    @Getter
    public static class  Node {

        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }


    }


}
