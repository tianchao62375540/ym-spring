package com.atomic.lock;

/**
 * @Auther: tianchao
 * @Date: 2020/2/8 17:08
 * @Description:
 */
public class Test implements Runnable{
     boolean run = false;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Thread.currentThread().getName().equals("t1")){
            run = true;
            return;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t1 = new Thread(test,"t1");
        t1.start();
        /*Thread t2 = new Thread(test,"t2");
        t2.start();*/

        while (true){
            if (test.run){
                System.out.println("=================");
                break;
            }

        }
        System.out.println("可见");


    }
}
