package com.atomic.thread;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    private Lock lock =new ReentrantLock();

    private Condition condition = lock.newCondition();

    public Clerk(int product) {
        this.product = product;
    }

    public  void get() {
        lock.lock();
        try {
            while (product>=1){
                System.out.println("产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" : "+ ++product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }


    }

    public synchronized void sale(){
        lock.lock();
        try {
            while (product<=0){
                System.out.println("缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" : "+ --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }


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
