package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.PeopleUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class Game {

    private static final int MAX_ROUND_COUNT = 20;

    public static void start(Round round) {
        int currentRoundCount = 1;

        while (currentRoundCount <= MAX_ROUND_COUNT) {
            log.info("round {} start!", currentRoundCount);
            log.info("===============");
            log.debug("attacker: {}", round.getAttacker());
            log.debug("defender: {}", round.getDefender());

            round.getAttacker().attack(round.getDefender());
            if (PeopleUtils.isDead(round.getDefender())) {
                log.info("defender is dead");
                break;
            }

            round.getDefender().attack(round.getAttacker());
            if (PeopleUtils.isDead(round.getAttacker())) {
                log.info("attacker is dead");
                break;
            }

            log.info("===============");
            log.info("round {} end!", currentRoundCount);
            log.info("");
            currentRoundCount++;
        }
    }
}
