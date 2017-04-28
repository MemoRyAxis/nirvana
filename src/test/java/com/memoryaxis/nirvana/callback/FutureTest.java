package com.memoryaxis.nirvana.callback;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author memoryaxis@gmail.com
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> new Random().nextInt(100));

        Thread.sleep(5000);
        System.out.println(future.get());
    }

}
