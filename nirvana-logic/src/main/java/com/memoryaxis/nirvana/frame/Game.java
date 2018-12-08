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
            log.debug("p1: {}", round.getP1());
            log.debug("p2: {}", round.getP2());

            attack(round.getP1(), round.getP2());
            if (PeopleUtils.isDead(round.getP2())) {
                log.info("p2 is dead");
                break;
            }

            attack(round.getP2(), round.getP1());
            if (PeopleUtils.isDead(round.getP1())) {
                log.info("p1 is dead");
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
            defendP.setCurrentHp(defendP.getCurrentHp() - attackP.getAtk() * 2);
            log.info("p1: use skill!");
            PeopleUtils.afterSkill(attackP);
        } else {
            defendP.setCurrentHp(defendP.getCurrentHp() - attackP.getAtk());
            PeopleUtils.afterAttack(attackP);
        }
    }
}
