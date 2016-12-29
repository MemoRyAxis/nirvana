package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mz on 12/29/2016.
 */
public class Round implements Lifecycle {

    private static final Logger log = LoggerFactory.getLogger(Round.class);

    private People people;

    private Team a;

    private Team b;

    private boolean isStarted = false;

    @Override
    public void ready() {
        // print log
        // buffs
        // etc.
    }

    @Override
    public void start() {
        // logic

        this.isStarted = true;
    }

    @Override
    public void over() {
        this.isStarted = false;

        // print log
        // people skill
        // buffs
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

}
