package com.struct;

import lombok.ToString;

/**
 * 模拟网站
 */
public class SampleBrowser {


    private String currentUrl;
    //历史
    private LinkedStack backStack;
    //前进
    private LinkedStack frowardStack;


    public SampleBrowser() {
        backStack = new LinkedStack();
        frowardStack = new LinkedStack();
    }

    public static void main(String[] args) {

        SampleBrowser sampleBrowser = new SampleBrowser();

        sampleBrowser.open("http://www.google.com_1");
        sampleBrowser.open("http://www.google.com_2");
        sampleBrowser.open("http://www.google.com_3");

        sampleBrowser.goBack();
        sampleBrowser.goBack();

        sampleBrowser.goBack();

        sampleBrowser.goFroward();
        sampleBrowser.goFroward();

        sampleBrowser.goFroward();

    }

    public void open(String url) {
        if (currentUrl != null) {
            this.backStack.push(this.currentUrl);
            this.frowardStack.clear();
        }
        currentUrl = url;
        System.out.println("Opening URL: " + url);
    }

    public void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("Nothing to go back");
            return;
        } else {
            frowardStack.push(currentUrl);
            this.currentUrl = backStack.pop().data;
            System.out.println("go back current url: " + currentUrl);
        }
    }

    public void goFroward() {
        if (frowardStack.isEmpty()) {
            System.out.println("No froward");
        } else {
            backStack.push(currentUrl);
            LinkedStack.Node node = frowardStack.pop();
            this.currentUrl = node.data;
            System.out.println("go forward current url: " + currentUrl);
        }
    }

    private static class LinkedStack {

        public boolean isEmpty() {
            return top == null;
        }

        public void clear() {
            this.top = null;
        }

        @ToString
        private static class Node {
            String data;
            Node next;

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        //栈顶指针
        private Node top;

        private void createNode(String data) {
            Node node = new Node(data, null);
        }


        public Node getTop() {
            if (top == null) {
                return null;
            }
            return top;
        }

        public void push(String data) {
            Node newNode = new Node(data, null);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }

        public Node pop() {
            if (top == null) {
                return null;
            } else {
                Node temp = top;
                top = top.next;
                return temp;
            }
        }

        private void printStack() {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }


}
