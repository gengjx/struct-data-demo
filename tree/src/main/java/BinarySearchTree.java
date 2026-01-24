public class BinarySearchTree {


    private Node tree;



    public Node find(int target){
        if(tree == null){
            return null;
        }
        Node current = tree;
        while(current != null){
            if(target == current.data){
                return current;
            }
            if(target < current.data){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return null;
    }

    public void insert(int target){
        //根节点为空
        if(tree == null){
            tree = new Node(target);
            return;
        }
        Node current = tree;
        while(current != null){
            if(target < current.data){
                if(current.left == null){
                    current.left = new Node(target);
                    return;
                }
                current = current.left;
            }else {
                if(current.right == null){
                    current.right = new Node(target);
                    return;
                }
                current = current.right;
            }
        }
    }

    public void delete(int target){
        //要删除的节点
        Node p = tree;
        //节点的父节点
        Node pp = null;

        while(p != null && p.data != target){

            pp = p;
            if(target < p.data){
                p = p.left;
            }else {
                p = p.right;
            }
        }
        if(p == null){
            return;
        }

        if(p.left == null && p.right == null){
            Node minP  = p.right;
            Node minPP = p;
            while(minPP.left != null){
                minPP = minP;
                minPP = minPP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        Node child = null;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else {
            child = null;
        }

        if(pp == null){
            tree = child;
        }else if(pp.left == p){
            pp.left = child;
        }else{
            pp.right = child;
        }
    }


    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }



    static class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }


}
