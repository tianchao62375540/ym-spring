package com.atomic.volatilefox;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 * 重排序
 */
public class ReOrderTest {

    private static int x = 0, y = 0;
    private static  int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException{
        int i=0;

        while (true) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            /**
             *  x,y   1,1  1,0 0,1   0,0
             */
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(20000);
                    a = 1;   // volatile写 ，插入一个StoreLoad
                    // 手动增加一个内存屏障   s
                    // 内存屏障实现原理 lock
                    UnsafeFactory.getUnsafe().storeFence();
                    x = b;   // 先volatile读，再普通写
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    // 手动增加一个内存屏障
                    UnsafeFactory.getUnsafe().storeFence();
                    y = a;
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("第" + i + "次（" + x + "," + y + ")");

            if (x==0&&y==0){
                break;
            }
            Thread.sleep(10000000);

        }

    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }



}
