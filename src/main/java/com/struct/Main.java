package com.struct;

import org.junit.Test;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {

    @Test
    public void testLogN() {
        int i =1 ;
        int n = 100;
        int times = 1;

        while (i < n) {
            i = i*2;
            times++;
        }
        System.out.println("system run:"+times);

    }

    public void print(int n ){
        System.out.println(++n);

    }

    public void printN(int n){
        for (int i = 0; i < n; i++) {
            System.out.println(n);
        }
    }

    public void printN2(int n){
        for (int i = 0; i < n; i++) {
            System.out.println(n);
            for ( int j = 0; j < n; j++ ) {
                System.out.println(n*j);
            }
        }
    }


    public void printMN(int n,int m){

        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(m);
        }
    }

    public void printMN2(int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(i*j);
            }
        }

    }

}