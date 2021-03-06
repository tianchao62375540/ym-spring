package com.atomic.volatilefox;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class SingletonFactory {

    /**
     * 查看汇编指令
     * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
     */
    private volatile static SingletonFactory myInstance;

    public static SingletonFactory getMyInstance() {
        if (myInstance == null) {
            synchronized (SingletonFactory.class) {
                if (myInstance == null) {
                    myInstance = new SingletonFactory();
                }
            }
        }
        return myInstance;
    }

    public static void main(String[] args) {
        SingletonFactory.getMyInstance();
    }
}
