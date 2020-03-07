package com.atomic.thread;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: tianchao
 * @Date: 2020/2/23 23:35
 * @Description:
 */
public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        new Thread(()->{
            demo.write();
        },"write").start();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                demo.read();
            },"read"+i).start();
        }




    }



}
class ReadWriteLockDemo{
    private int num;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        lock.readLock().lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName()+" : "+num);

        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName());
            this.num = 10;

        }finally {
            lock.writeLock().unlock();
        }
    }
}