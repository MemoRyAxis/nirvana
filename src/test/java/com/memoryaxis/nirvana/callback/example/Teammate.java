package com.memoryaxis.nirvana.callback.example;

/**
 * @author memoryaxis@gmail.com
 */
public class Teammate implements Worker {

    @Override
    public void doTask(Leader leader) {
        System.out.println("teammate do the task.");
        try {
            System.out.println("task logic");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("teammate finished the task.");
        leader.finishTask();
    }

}
