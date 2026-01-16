package com.struct;

public class LRUBaseLinkedList<T> {



    private int capacity;

    private Node<T> head;

    private int size;


    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node<>();

    }

    public void add(T data) {
        Node<T> pre =findNodePre(data);

        if(pre != null){
            deletePreHead(pre);
            insertHead(data);

        }else{
            if (size >= capacity) {
                deleteTailHead();
            }
            insertHead(data);
        }

    
    
    }


    private void deletePreHead(Node<T> pre) {
        pre.next = pre.next.next;
        size--;

    }

    private void deleteTailHead() {
        Node ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.next = null;
        tmp = null;
        size--;

    }

    private void insertHead(T data) {
        Node tmp = head.next;
        head.next  = new Node<T>(data, tmp);

    }

    private Node<T> findNodePre(T data) {
        
        Node tmp = head;

        while (tmp.next != null) {
            if (tmp.next.getData().equals(data)) {
                return tmp;
            }
            tmp = tmp.next;
        
        }
        return null;
    }

    private void printAll(){

        Node node = this.head.next;

        while (node != null) {
            System.out.print(node.getData());
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> linkedList = new LRUBaseLinkedList<>(10);

        linkedList.add(1);

        
        linkedList.printAll();

        linkedList.add(2);

        linkedList.printAll();

        linkedList.add(1);

        linkedList.printAll();

        linkedList.add(3);

        linkedList.printAll();

    }







    static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }

        
        public String toString() {
            return data.toString();
        }

        public T getData(){
            return data;
        }

        public Node getNext(){
            return this.next;
        }

    }

}
