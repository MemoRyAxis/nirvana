package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.Team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class Battle implements Lifecycle {

    private static final Logger log = LoggerFactory.getLogger(Battle.class);

    private Team a;

    private Team b;

    private boolean isStarted = false;

    private static final int MAX_ROUND_COUNT = 30;

    private int currentRound = 0;

    public Battle setA(Team a) {
        this.a = a;
        return this;
    }

    public Battle setB(Team b) {
        this.b = b;
        return this;
    }

    @Override
    public void ready() {
        log.info("Battle Start!");
        currentRound = 1;
    }

    @Override
    public void start() {
        try {
            if (a == null || b == null)
                throw new Exception("Start Battle Fail!");

            this.isStarted = true;

            while (currentRound <= MAX_ROUND_COUNT
                    && !a.isOver()
                    && !b.isOver()) {
                Round round = new Round(currentRound)
                        .setA(a)
                        .setB(b);
                round.ready();
                round.start();
                round.over();
                currentRound++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error("Start Battle Fail!", e);
        }
    }

    @Override
    public void over() {
        this.isStarted = false;

        if (!a.isOver()) {
            log.info("Team a Win!");
        }
        if (!b.isOver()) {
            log.info("Team b Win!");
        }

        // print log

        log.info("Battle End.");
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

}
