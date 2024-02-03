package com.ldl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMainTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ThreadTest().start();
        new Thread(new RunnableTest()).start();

        FutureTask<String> threadTask= new FutureTask<>(new CallableTest("带返回值的"));
        new Thread(threadTask).start();
        System.out.println(threadTask.get());

        new Thread(()->{
            System.out.println("lambda:" + Thread.currentThread().getName());
        }).start();

    }

}
class ThreadTest extends Thread{
    @Override
    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName());
        super.run();
    }
}

class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable:" + Thread.currentThread().getName());
    }
}

class CallableTest implements Callable<String> {

    private String name;
    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Callable:" + Thread.currentThread().getName());
        return name;
    }
}
