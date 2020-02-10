package com.atomic.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: tianchao
 * @Date: 2020/2/9 17:37
 * @Description:
 */
public class ThreadInterruptTest implements Runnable{



    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterruptTest());
        thread.start();
        Thread.sleep(2000);
        //thread.interrupt();
        thread.interrupt();
        //LockSupport.unpark(thread);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("running");
            /*if (Thread.currentThread().isInterrupted()){
                System.out.println("======================");
            }*/
            LockSupport.park();
            System.out.println("run end.....");
        }
    }

}
