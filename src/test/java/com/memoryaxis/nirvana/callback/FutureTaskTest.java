package com.memoryaxis.nirvana.callback;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author memoryaxis@gmail.com
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = () -> {
            Thread.sleep(5000);
            return new Random().nextInt(100);
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

//        while (!futureTask.isDone()) {
//            System.out.println("future is not done");
//            Thread.sleep(1);
//        }
        System.out.println(futureTask.cancel(true));
        System.out.println(futureTask.cancel(false));

        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.isDone());

        System.out.println("some logic");

        Thread.sleep(500);
        System.out.println(futureTask.get());
    }

}
