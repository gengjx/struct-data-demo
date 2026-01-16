package com.struct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {





    }

    @Test
    public void test() {

        Node head = new Node();
        insert(head, 1);
        printList(head);
        insert(head, 2);
        printList(head);
        insert(head, 3);
        printList(head);
        insert(head, 4);
        printList(head);

    }

    @Test
    public void test2() {
        Node head = new Node();
        tailInsert(head, 1);
        printList(head);
        tailInsert(head, 2);
        printList(head);
    }





    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @ToString
    protected static class Node{
        Integer data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(Node head, int data){
        Node newNode = new Node(data);
        if(head.next != null){
            newNode.next = head.next;
        }
        head.next = newNode;
    }

    public void tailInsert(Node head, int data){
        Node newNode = new Node(data);
        Node tail = head.next;
        if (tail == null){
            tail = newNode;
            head.next = tail;
            return;
        }
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = newNode;
    }

    private void printList(Node head){
        Node temp = head.next;
        while(temp != null){
            System.out.print(temp.data +",");
            temp = temp.next;
        }
        System.out.println();
    }
}