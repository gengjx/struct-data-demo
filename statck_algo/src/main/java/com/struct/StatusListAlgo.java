package com.struct;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 单链表翻转
 */
public class StatusListAlgo {



    public static void main(String[] args) {
        StatusListAlgo statusListAlgo = new StatusListAlgo();
        int [] arr = {1,2,3,4,5,6,7,8,9};
        Node head = new Node();
        for (int i : arr) {
            statusListAlgo.addHead(i, head);
        }
        statusListAlgo.printList(head);
        statusListAlgo.reverse(head);
        statusListAlgo.printList(head);


        statusListAlgo.findMidNode(head).getValue();

        Node tmp = new Node(10,null);

        Node tmp2 = new Node(20,null);

        Node tmp3 = new Node(30,null);
        tmp.next = tmp2;
        tmp2.next = tmp3;
        System.out.println(statusListAlgo.checkCircle(tmp));

        statusListAlgo.printList(tmp);

       Node mergeList =  statusListAlgo.mergeSortList(head,tmp);

       statusListAlgo.printList(mergeList);

      Node list =  statusListAlgo.deleteLastKth(mergeList,13);
      statusListAlgo.printList(list);




    }

    Node mergeSortList(Node p, Node q) {
        if(p == null) return q;
        if(q == null) return p;

        Node head;
        Node left = p;
        Node right = q;
        Node curr;
        if (left.getValue() < right.getValue()) {
            head = new Node(left.getValue(), null);
            left = left.next;
        }else {
            head = new Node(right.getValue(), null);
            right = right.next;
        }
        curr = head;
        while(left != null && right != null) {
            if(left.getValue() < right.getValue()) {
               curr.next = left;
                left = left.next;

            }else{
               curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return head;
    }



    Node  reverse(Node head) {
        if (head == null || head.next == null) {
            return head;  // 空链表或只有哨兵节点
        }
        Node dummy = head;        // 哨兵节点
        Node first = head.next;   // 第一个实际节点
        Node prev = null;
        Node curr = first;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        dummy.next = prev;  // 哨兵指向新的第一个节点
        return dummy;       // 返回哨兵节点
    }

    void addHead(int data,Node head) {
        Node tmp = new Node(data,null);
        tmp.next = head.next;
        head.next = tmp;
    }

    void addTail(int data,Node head) {
        if(head == null){
            head = new Node(data,null);
        }
        Node tmp = new Node(data,null);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tmp;
    }

    Node findMidNode(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head;
        }
        Node fast = head.next;
        Node slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            System.out.println(slow +" "+slow.next);
        }else {
            System.out.println(slow);
        }
        return slow;
    }



    private void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getValue());
            curr = curr.next;
        }
        System.out.println();
    }

    private boolean checkCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast !=  null && fast.next !=  null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.next == fast) {
                return true;
            }
        }
        return false;
    }

    //删除第k个节点
    public Node deleteLastKth(Node list, int k){
        Node deleteNode = list;
        int index = 0;
        while (deleteNode != null && index < k) {
            deleteNode = deleteNode.next;
            ++index;
        }
        if (deleteNode == null || deleteNode.next == null) {
            return list;
        }

        Node prev = list;

        while (prev.next != deleteNode) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return list;
    }



    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Data
    private static class Node{
        private int value;
        private Node next;

        private int getValue(){
            return this.value;
        }

    }

}
