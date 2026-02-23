package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

@Slf4j
public class SemaphoreDemo7 {

    static void main() {
        LoginService loginService = new LoginService(10);

        IntStream.range(0, 20).forEach(i -> {

            new Thread(()->{
                boolean login = loginService.login();
                if(!login){
                   log.info("{}登陆失败",Thread.currentThread().getName());
                }
                try {
                    TimeUnit.SECONDS.sleep(current().nextInt(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    loginService.logout();
                }

            },"t_"+i).start();

        });

    }


   static class LoginService{

       private Semaphore semaphore;

       public LoginService(int permits){
           semaphore = new Semaphore(permits,true);
       }

       public boolean login(){
           boolean login = semaphore.tryAcquire();
           if(login){
                log.info(Thread.currentThread().getName() + " 登陆成功");
           }
           return login;
       }

       public void logout(){
           semaphore.release();
           log.info(Thread.currentThread().getName()+ " 退出登陆");

       }


    }

}
