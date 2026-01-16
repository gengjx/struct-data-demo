package com.struct;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedList {
    private Node head;


    public SinglyLinkedList() {
        head = null;
    }

    private void insertAtHead(int data) {
        Node newNode = new Node(data,null);
        if (head == null) {
            head = newNode;
        }else{
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    private void insertAtTail(int data) {
        Node newNode = new Node(data,null);
        if (head == null) {
            head = newNode;
        }else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private Node findByValue(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private int findByIndex(int index){
        Node temp = head;
        int position = 0;
        while (temp != null && position < index) {
            position++;
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean palindrome(){
        Node temp = head;
        if (temp == null){
            return false;
        }
        if (temp.next == null){
            return true;
        }
        Node p = temp;
        Node  q= temp;
        while (q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }
        Node left = null;
        Node right = null;
        if (q.next == null){
            System.out.println("链表是个奇数，中间节点"+p.data);
             left  = inverseLinkList(p).next;
             right = p.next;
        }else{

            System.out.println("链表的左边节点"+p.data);
            System.out.println("链表右边"+p.next.data);
            right = p.next;
            left = inverseLinkList(p);


        }
        
        
        return TFResult(left,right);
    }

    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while(l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else{
                flag=false;
                break;
            }

        }

        System.out.println("什么结果:"+flag);
        return flag;
       /* if (l==null && r==null){
           System.out.println("什么结果");
           return true;
        }else{
           return false;
        }*/
    }

    private Node inverseLinkList(Node left) {

        //下一个节点
        Node next = null;

        //已经处理的节点
        Node prev = null;

        //当前要处理的节点
        Node current = head;

        while (current != left) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return current;
    }


    @AllArgsConstructor
    private static class Node {

        private int data;
        private Node next;

    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtTail(3);
        list.printList();
        Assert.assertNotEquals(null, list.findByValue(2));
        Assert.assertNull(list.findByValue(10));
        list.insertAtTail(4);
        list.printList();
        list.insertAtHead(5);
        list.printList();
        Assert.assertEquals(5, list.findByIndex(1));
        
        
        SinglyLinkedList list2 = new SinglyLinkedList();
        
        int []a = new int[]{1,2,3,3,2,1};

        for (int i = 0; i < a.length; i++) {
            list2.insertAtTail(a[i]);
        }

        list2.printList();

        list2.palindrome();




    }

}
