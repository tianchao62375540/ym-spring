package com.tc.pk;

/**
 * @Auther: tianchao
 * @Date: 2020/3/2 22:14
 * @Description:
 */
public class Thread01 extends Thread {
    @Override
    public void run() {
        System.out.println("thread01....");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread01().start();
        Thread.sleep(Long.MAX_VALUE);
        System.out.println("main-end...");
    }
}
