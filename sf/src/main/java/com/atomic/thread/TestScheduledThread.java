package com.atomic.thread;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/24 20:52
 * @Description:
 */
public class TestScheduledThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName()+" : "+num+ DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
                    return num;
                }
            }, i, TimeUnit.SECONDS);

        }
        pool.shutdown();

    }
}
