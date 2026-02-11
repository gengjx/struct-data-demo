package com.struct.concurrency.demo.cas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    static void main() {

        User user1 = new User("张三",100);
        User user2 = new User("李四",200);

        AtomicReference<User> atomicReference = new AtomicReference<>(user1);
        System.out.println(atomicReference.get());
        System.out.println(atomicReference.compareAndSet(user1,user2));
        System.out.println(atomicReference.get());

    }

    @Data
    @AllArgsConstructor
    static class User{
        private String name;
        private Integer age;

    }

}
