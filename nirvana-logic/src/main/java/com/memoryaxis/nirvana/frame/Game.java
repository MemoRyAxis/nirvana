package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.frame.people.People;
import com.memoryaxis.nirvana.frame.people.PeopleUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class Game {

    private static final int MAX_ROUND_COUNT = 20;

    public static void start(Round round) {
        int currentRoundCount = 1;
        People attackPeople = round.getAttacker();
        People defendPeople = round.getDefender();

        while (currentRoundCount <= MAX_ROUND_COUNT) {
            log.info("round {} start!", currentRoundCount);
            log.info("===============");
            log.debug("attacker: {}", round.getAttacker());
            log.debug("defender: {}", round.getDefender());

            attackPeople.doAction(defendPeople, null, null);
            if (PeopleUtils.isDead(round.getDefender())) {
                log.info("defender is dead");
                break;
            }

            defendPeople.doAction(attackPeople, null, null);
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
