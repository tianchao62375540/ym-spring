package com.atomic.sync;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class Test {

    private int i=0;

    public void test(){
        synchronized (this){
            i++;
        }
    }


}
