package com.tc.pk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 源码学院-Monkey
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class ThreadPool01 implements  Runnable {
   public static void main(String[] args) {
      ExecutorService executorService = Executors.newCachedThreadPool();
      //executorService.submit(()->   System.out.println("源码学院-monkey老师"));
      executorService.execute(new ThreadPool01());
 /*     executorService.submit(new Runnable() {
         @Override
         public void run() {

            System.out.println("源码学院-monkey老师");
         }
      });*/
      try {
         Thread.sleep(Integer.MAX_VALUE);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      executorService.shutdownNow();

   }

   @Override
   public void run() {
      System.out.println("abc");
   }
}
