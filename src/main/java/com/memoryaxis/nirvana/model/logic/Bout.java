package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.buff.Aspect;
import com.memoryaxis.nirvana.model.base.buff.Buff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ListIterator;

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
        buffOn(currentPeople, Aspect.BOUT_READY);
        // etc.
    }

    private void buffOn(People currentPeople, Aspect aspect) {
        ListIterator<Buff> buffs = currentPeople.getBuffs().listIterator();
        while (buffs.hasNext()) {
            Buff buff = buffs.next();
            if (aspect.equals(buff.getAspect())) {
                try {
                    buff.effect(currentPeople);
                } catch (Exception e) {
                    log.error("Add Buff Error!", e);
                }
                if (!buff.isEffective()) {
                    buffs.remove();
                }
            }
        }
    }

    @Override
    public void start() {
        try {
            this.isStarted = true;

            buffOn(currentPeople, Aspect.BOUT_START);

            if (currentPeople.getAp() != null && currentPeople.getAp() > 100) {
                log.info("[{}]怒击", currentPeople.getName());
                for (Action action : currentPeople.getSuperActions()) {
                    action.action(a, b);

                    buffOn(currentPeople, Aspect.AT_ONCE);
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
