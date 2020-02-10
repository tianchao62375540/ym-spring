package com.atomic.atomic;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tianchao
 * @Date: 2020/2/9 16:59
 * @Description:
 */
public class Test {
    private static int num = 0;
    private static AtomicInteger anInt = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    num++;
                    anInt.getAndIncrement();
                }
            });
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(num);
        System.out.println(anInt.get());
    }
}
