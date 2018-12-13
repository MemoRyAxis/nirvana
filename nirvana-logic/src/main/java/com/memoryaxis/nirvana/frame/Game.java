package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.PeopleUtils;
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
            log.debug("attacker: {}", round.getAttacker());
            log.debug("defender: {}", round.getDefender());

            attack(round.getAttacker(), round.getDefender());
            if (PeopleUtils.isDead(round.getDefender())) {
                log.info("defender is dead");
                break;
            }

            attack(round.getDefender(), round.getAttacker());
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

    private static void attack(People attackP, People defendP) {
        if (PeopleUtils.haveSkill(attackP)) {
            // 实现技能效果
            attackP.getSkill().action(attackP, defendP);
            log.info("attacker: use action!");
            attackP.afterSkill();
        } else {
            attackP.getAction().action(attackP, defendP);
            attackP.afterAttack();
        }
    }
}
