package com.struct;

import lombok.Data;
import lombok.ToString;

public class SkipList1 {

    @Data
    @ToString
    class Node{
        int value;
        Node [] forwards = new Node[MAX_LEVEL];
        private int maxValue;
    }

    //最高层
    private static final int MAX_LEVEL = 16;

    //当前层
    private int level = 1;

    //晋升概率
    private final float LEVEL_P = 0.5f;

    Node head = new Node();

    public Node find(int target){

        Node current = head;

        int level = this.level -1;

        for (int i = level; i >= 0; i--) {
            while (current.forwards[i] != null && current.forwards[i].value < target) {
                current = current.forwards[i];
            }
        }

        if (current.forwards[0] != null && current.forwards[0].value == target) {
            return current.forwards[0];
        }else {
            return null;
        }
    }

    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.value = value;
        newNode.maxValue = level;
        Node[] updates = new Node[level];
        int currentLevel = level -1;
        Node current = head;
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forwards[i] != null && current.forwards[i].value < value) {
                current = current.forwards[i];
            }
            updates[i] = current;
        }

        for (int i = 0; i < level; i++) {
             newNode.forwards[i] = updates[i].forwards[i];
             updates[i].forwards[i] = newNode;
        }

        if(this.level < level){
            this.level = level;
        }
    }

    public void delete(int value){

        Node target = head;
        int level = this.level -1 ;
        Node [] updates = new Node[this.level];
        for (int i = level; i >= 0; i--) {
           while (target.forwards[i] != null && target.forwards[i].value < value) {
               target = target.forwards[i];
           }
           updates[i] = target;
        }

        if (target.forwards[0] != null && target.forwards[0].value == value) {
                for (int i = level; i >= 0; i--) {
                    if (target.forwards[i] != null && target.forwards[i].value == value) {
                        target.forwards[i] = target.forwards[i].forwards[i];
                    }
                }
        }

        while(level > 1 && head.forwards[level] == null){
            this.level--;
        }



    }


    public int randomLevel(){
        int level = 1;
        while (Math.random() < LEVEL_P && level < MAX_LEVEL){
            level++;
        }
        return level;
    }

    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].value : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }


    public static void main(String[] args) {

        SkipList1 list = new SkipList1();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(8);
        list.insert(7);
        list.insert(9);
        list.insert(10);
        list.printAll_beautiful();


        Node n = list.find(1);

        list.delete(1);

        list.printAll_beautiful();
    }





}
