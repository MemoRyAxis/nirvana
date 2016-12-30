package com.memoryaxis.nirvana.model.action.attack.pa;

import com.memoryaxis.nirvana.model.action.attack.Attack;
import com.memoryaxis.nirvana.model.base.People;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mz on 12/26/2016.
 */
public abstract class PhysicalAttack extends Attack {

    private static final Logger log = LoggerFactory.getLogger(PhysicalAttack.class);

    @Override
    protected void doAttack(People p1, People p2) throws Exception {

        Integer damage = p1.getPa();

        Integer p2hpBefore = p2.getHp();

        p2.decreaseHp(damage);

        log.debug("人员[{}]对人员[{}]造成{}点伤害", p1.getName(), p2.getName(), p2hpBefore - p2.getHp());

        if (p2.isAlive()) {
            p2.increaseAp(30);
            log.debug("人员[{}]回复{}点怒气", p2.getName(), 30);
        } else {
            log.debug("人员[{}]把人员[{}]带走", p1.getName(), p2.getName());
        }
    }

}
