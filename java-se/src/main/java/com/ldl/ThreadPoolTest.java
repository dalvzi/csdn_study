package com.ldl;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, // corePoolSize
                10, // maximumPoolSize
                60, // keepAliveTime
                TimeUnit.SECONDS, // unit
                new LinkedBlockingQueue<>(), // workQueue
                Executors.defaultThreadFactory(), //线程工厂
                new ThreadPoolExecutor.AbortPolicy() //拒绝策略
        );

    }

    @Test
    public void test_schedule4Runnable() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture future = service.schedule(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));

        System.out.println("Runnable future's result is: " + future.get() +
                ", and time is: " + format(System.currentTimeMillis()));
    }

    //2
    @Test
    public void schedule4CallableTest() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> future = service.schedule(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
            return "success";
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));

        System.out.println("Callable future's result is: " + future.get() +
                ", and time is: " + format(System.currentTimeMillis()));
    }

    //3
    @Test
    public void scheduleAtFixedRateTest() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 5000L, 1000L, TimeUnit.MILLISECONDS);

        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));
        while (true) {
        }
    }

    // 4
    @Test
    public void scheduleWithFixedDelayTest() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + format(System.currentTimeMillis()));
        }, 1000L, 1000L, TimeUnit.MILLISECONDS);

        System.out.println("schedule finish time: " + format(System.currentTimeMillis()));
        while (true) { }
    }

    private String format(long currentTimeMillis) {
        // 创建SimpleDateFormat对象并指定日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 使用format方法将时间戳格式化成字符串
        String formattedDate = sdf.format(new Date(currentTimeMillis));
        return formattedDate;
    }

}
