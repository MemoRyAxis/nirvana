package com.memoryaxis.nirvana.callback;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author memoryaxis@gmail.com
 */
public class MultiFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            completionService.submit(() -> taskId);
        }

        System.out.println("do something.");

        for (int i = 0; i < 5; i++) {
            System.out.println(completionService.take().get());
        }
    }

}
