package com.atomic.volatilefox;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 * 可见性
 */
public class VisibilityForObjTest {

    private     boolean  flag = false;


    public void refresh(){
        this.flag = true;
        System.out.println(Thread.currentThread().getName()+"修改flag"+flag);
    }

    public void load(){

        while (!flag){
            int i = 100;
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
           }*/

            //shortWait(1);

        }
        System.out.println(Thread.currentThread().getName()+"跳出循环: flag="+ flag);
}

    public static void main(String[] args) throws InterruptedException {

        VisibilityForObjTest test = new VisibilityForObjTest();


        new Thread(() -> test.load(), "threadA").start();


        try {
            Thread.sleep(2000);

            new Thread(()->test.refresh(),"threadB").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======================");



    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }




}
