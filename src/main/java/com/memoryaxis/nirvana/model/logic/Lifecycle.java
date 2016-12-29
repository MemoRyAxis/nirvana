package com.memoryaxis.nirvana.model.logic;

/**
 * Created by mz on 12/28/2016.
 */
public interface Lifecycle {

    void ready();

    void start();

    void over();

    boolean isStarted();

}
