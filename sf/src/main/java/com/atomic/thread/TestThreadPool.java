package com.atomic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/24 20:36
 * @Description:
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo demo = new ThreadPoolDemo();
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }

       /* for (int i = 0; i < 2; i++) {
            pool.submit(demo);
        }*/
        //System.out.println("down before");
        pool.shutdown();
        //System.out.println("down after");
        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }

}
class ThreadPoolDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        while (i<=100){
            System.out.println(Thread.currentThread().getName()+" : "+i++);
        }
    }
}