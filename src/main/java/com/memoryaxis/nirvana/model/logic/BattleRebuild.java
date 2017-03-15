package com.memoryaxis.nirvana.model.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class BattleRebuild extends Battle {

    private static final Logger LOGGER = LoggerFactory.getLogger(BattleRebuild.class);

    private static final int MAX_ROUND_COUNT = 30;

    private int currentRound = 0;

    @Override
    public void start() {
        try {
            if (getA() == null || getB() == null)
                throw new Exception("Start Battle Fail!");

            while (currentRound <= MAX_ROUND_COUNT
                    && !getA().isOver()
                    && !getB().isOver()) {
                Round round = new RoundRebuild(currentRound)
                        .setA(getA())
                        .setB(getB());
                round.ready();
                round.start();
                round.over();
                currentRound++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            LOGGER.error("Start Battle Fail!", e);
        }
    }

}
