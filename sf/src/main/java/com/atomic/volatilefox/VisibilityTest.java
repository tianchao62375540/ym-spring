package com.atomic.volatilefox;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 * 可见性
 */
public class VisibilityTest {
    class BooleanObj{
        boolean flag = false;
    }
    private     final      BooleanObj booleanObj = new BooleanObj();


    public void refresh(){
        this.booleanObj.flag = true;
        System.out.println(Thread.currentThread().getName()+"修改flag"+this.booleanObj.flag);
    }

    public void load(){

        while (!this.booleanObj.flag){
            int i = 100;
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
           }*/

            //shortWait(1);

        }
        System.out.println(Thread.currentThread().getName()+"跳出循环: flag="+ this.booleanObj.flag);
}

    public static void main(String[] args) throws InterruptedException {

        VisibilityTest test = new VisibilityTest();


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
