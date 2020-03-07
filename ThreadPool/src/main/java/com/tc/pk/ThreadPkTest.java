package com.tc.pk;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 源码学院-Monkey
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 * 没有用线程池
 */
public class ThreadPkTest {
    public static void main(String[] args) throws InterruptedException {
        Long start= System.currentTimeMillis();
        final List<Integer> l=new ArrayList<Integer>();
        final Random random=new Random();
        for(int i=0;i<10000;i++){
            Thread thread=new Thread(){
                public void run(){
                    l.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();//这个join的目的???
        }
        System.out.println("时间:"+(System.currentTimeMillis()-start));
        System.out.println("size:"+l.size());

    }
}
