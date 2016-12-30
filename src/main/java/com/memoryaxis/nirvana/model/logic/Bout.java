package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.buff.Aspect;
import com.memoryaxis.nirvana.model.base.buff.Buff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class Bout implements Lifecycle {

    private static final Logger log = LoggerFactory.getLogger(Bout.class);

    private People currentPeople;

    private Team a;

    private Team b;

    private boolean isStarted = false;

    Bout() {
    }

    Bout setCurrentPeople(People currentPeople) {
        this.currentPeople = currentPeople;
        return this;
    }

    public Bout setA(Team a) {
        this.a = a;
        return this;
    }

    public Bout setB(Team b) {
        this.b = b;
        return this;
    }

    @Override
    public void ready() {
        // print log
        // buffs
        for (Buff buff : currentPeople.getBuffs()) {
            if (buff.getAspect().equals(Aspect.BOUT_READY)) {
                try {
                    buff.effect(currentPeople);
                } catch (Exception e) {
                    log.error("Add Buff Error!", e);
                }
            }
        }
        // etc.
    }

    @Override
    public void start() {
        try {
            this.isStarted = true;

            if (currentPeople.getAp() != null && currentPeople.getAp() > 100) {
                currentPeople.getSuperAction().action(a, b);
                currentPeople.decreaseAp(100);
            } else {
                currentPeople.getBaseAction().action(a, b);
            }
        } catch (Exception e) {
            log.error("Bout Error!", e);
        }
    }

    @Override
    public void over() {
        this.isStarted = false;

        // print log
        // buffs
        // etc.

    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

}
