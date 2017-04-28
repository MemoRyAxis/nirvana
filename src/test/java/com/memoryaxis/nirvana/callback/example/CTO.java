package com.memoryaxis.nirvana.callback.example;

/**
 * @author memoryaxis@gmail.com
 */
public class CTO implements Leader {

    @Override
    public void newTask() {
        System.out.println("CTO have a new task.");
        new TeamLeader().doTask(this);
    }

    @Override
    public void finishTask() {
        System.out.println("CTO finished the task.");
    }

}
