package com.atomic.thread.productnew;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tianchao
 * @Date: 2020/2/23 22:08
 * @Description:
 */
public class ProductorConsumerTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);
        Clerk clerk = new Clerk(0);
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);
        new Thread(()->{
            productor.produce();
            cdl.countDown();
        },"生产者A").start();
        new Thread(()->{
            customer.consume();
            cdl.countDown();
        },"消费者A").start();
        new Thread(()->{
            productor.produce();
            cdl.countDown();
        },"生产者B").start();
        new Thread(()->{
            customer.consume();
            cdl.countDown();
        },"消费者B").start();

        cdl.await();
        System.out.println("=====================end========================");
    }




}

class Clerk{
    private int product = 0;

    public Clerk(int product) {
        this.product = product;
    }

    public synchronized void get() {
        while (product>=1){
            System.out.println("产品已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ ++product);
        this.notifyAll();

    }

    public synchronized void sale(){
        while (product<=0){
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ --product);
        this.notifyAll();

    }
}

class Productor{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void produce(){
        for (int i = 0;i<20;i++){
            clerk.get();
        }
    }
}

class Customer{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void consume(){
        for (int i = 0;i<20;i++){
            clerk.sale();
        }
    }
}
