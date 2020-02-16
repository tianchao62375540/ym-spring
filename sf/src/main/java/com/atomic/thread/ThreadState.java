package com.atomic.thread;

/**
 * @Auther: tianchao
 * @Date: 2020/2/10 22:45
 * @Description:
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(500000);
    }
}
