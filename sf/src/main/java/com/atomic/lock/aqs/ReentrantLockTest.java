package com.atomic.lock.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: tianchao
 * @Date: 2020/2/9 21:16
 * @Description:
 */
public class ReentrantLockTest {
    public static int num = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                lock.lock();
                for (int j = 0; j < 10000; j++) {
                    num++;
                }
                lock.unlock();
            });
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(num);
    }
}
