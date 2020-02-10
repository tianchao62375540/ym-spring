package com.atomic.sync;


/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class Biaslock {

    private static Object object = new Object();
    /**
     * 默认开启偏向锁
     * 开启偏向锁：-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
     * 关闭偏向锁：-XX:-UseBiasedLocking
     * @param args
     */
    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        int count = 0;
        while(count < 100000000){
            synchronized (object){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
