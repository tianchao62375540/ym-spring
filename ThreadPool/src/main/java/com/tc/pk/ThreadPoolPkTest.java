package com.tc.pk;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 源码学院-Monkey
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class ThreadPoolPkTest {

    public static void main(String[] args) throws InterruptedException {
        Long start= System.currentTimeMillis();
        final List<Integer> list=new ArrayList<Integer>();
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        final Random random=new Random();
        for(int i=0;i<10000;i++){
            //final int j=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间:"+(System.currentTimeMillis()-start));
        System.out.println("size:"+list.size());


    }
}
