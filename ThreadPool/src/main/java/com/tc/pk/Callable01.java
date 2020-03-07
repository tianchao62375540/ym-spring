package com.tc.pk;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: tianchao
 * @Date: 2020/3/2 22:26
 * @Description:
 */
public class Callable01 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("callable...");
        return "===";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable01());
        new Thread(futureTask).start();

        System.out.println("==========end");
        System.out.println(futureTask.get());

    }
}
