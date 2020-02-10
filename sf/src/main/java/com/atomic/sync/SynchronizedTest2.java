package com.atomic.sync;

import java.util.Vector;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class SynchronizedTest2 {

    Vector<String> vector = new Vector<String>();

    /*
     锁的粗化
     */
    public void test(){

        for(int i = 0 ; i < 10 ; i++){
            vector.add(i + "");
        }
        vector.add("fox");
        vector.add("fox111");
        vector.add("fox222");

        /*synchronized (this){
            for
        }*/

    }

    /**
     * 锁的消除
     *
     * -XX:+EliminateLocks 开启同步消除
     */
    public void test2(){
        // jvm不会加锁   判断不会存在竞争，同步消除
        synchronized (new Object()){

           //TODO  业务逻辑
            Vector<String> vector = new Vector<String>();
            vector.add("fox");
            vector.add("fox111");
            vector.add("fox222");
        }

    }




}
