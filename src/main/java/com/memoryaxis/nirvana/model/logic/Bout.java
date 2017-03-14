package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.action.Action;
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

    public People getCurrentPeople() {
        return currentPeople;
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
        Buff.buffOn(currentPeople, Aspect.BOUT_READY);
        // etc.
    }

    @Override
    public void start() {
        try {
            this.isStarted = true;

            Buff.buffOn(currentPeople, Aspect.BOUT_START);

            if (currentPeople.getAp() != null && currentPeople.getAp() > 100) {
                log.info("[{}]怒击", currentPeople.getName());
                for (Action action : currentPeople.getSuperActions()) {
                    action.action(a, b);

                    Buff.buffOn(currentPeople, Aspect.AT_ONCE);
                }
                currentPeople.decreaseAp(100);
            } else {
                for (Action action : currentPeople.getBaseActions()) {
                    action.action(a, b);
                }
            }
        } catch (Exception e) {
            log.error("Bout Error!", e);
        }
    }

    @Override
    public void over() {
        Buff.buffOn(currentPeople, Aspect.BOUT_END);
        this.isStarted = false;

        // print log
        // buffs
        // etc.

    }

}
