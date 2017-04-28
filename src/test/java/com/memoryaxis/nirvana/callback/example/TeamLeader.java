package com.memoryaxis.nirvana.callback.example;

/**
 * @author memoryaxis@gmail.com
 */
public class TeamLeader implements Leader, Worker {

    @Override
    public void doTask(Leader leader) {
        this.newTask();
        leader.finishTask();
    }

    @Override
    public void finishTask() {
        System.out.println("team finished the task.");
    }

    @Override
    public void newTask() {
        System.out.println("team leader have a new task.");
        new Teammate().doTask(this);
    }

}
