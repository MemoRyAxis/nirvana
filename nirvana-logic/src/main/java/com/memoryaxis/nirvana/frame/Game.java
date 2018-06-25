package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class Game {

    private static final Logger log = LoggerFactory.getLogger(Game.class);

    private static final int MAX_ROUND_COUNT = 20;

    public static void start(Round round) {
        int currentRoundCount = 1;

        while (currentRoundCount <= MAX_ROUND_COUNT) {
            log.info("round {} start!", currentRoundCount);
            log.info("===============");
            log.debug("p1: {}", round.getP1());
            log.debug("p2: {}", round.getP2());

            attack(round.getP1(), round.getP2());
            if (round.getP2().isDead()) {
                log.info("p2 is dead");
                break;
            }

            attack(round.getP2(), round.getP1());
            if (round.getP1().isDead()) {
                log.info("p1 is dead");
                break;
            }

            log.info("===============");
            log.info("round {} end!", currentRoundCount);
            log.info("");
            currentRoundCount++;
        }
    }

    private static void attack(People attack, People defend) {
        defend.setCurrentHp(defend.getCurrentHp() - attack.getAtk());
    }
}
