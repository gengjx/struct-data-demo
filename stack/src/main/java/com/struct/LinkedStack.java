package com.struct;

import lombok.ToString;

public class LinkedStack {

    @ToString
    private static class Node {
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //栈顶指针
    private Node top;

    private void createNode(int data) {
        Node node = new Node(data, null);
    }


    public Node getTop() {
        if (top == null) {
            return null;
        }
        return top;
    }

    public void push(int data){
        Node newNode = new Node(data, null);
        if (top == null) {
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    public Node pop(){
        if (top == null) {
            return null;
        }else {
            Node temp = top;
            top = top.next;
            return temp;
        }
    }


    private void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.getTop());
        stack.printStack();
        stack.pop();
        stack.printStack();

    }


}
