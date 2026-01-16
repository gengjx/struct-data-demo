package com.struct;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }


    public static int  fibonacci(int n){
        if (n == 0 || n == 1) {
            return n;
        }
        if (n==2) {
            return 2;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}