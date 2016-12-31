package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ListIterator;

/**
 * @author memoryaxis@gmail.com
 */
public abstract class Buff {

    private static final Logger log = LoggerFactory.getLogger(Buff.class);

    private Aspect aspect = Aspect.AT_ONCE;

    private Integer duration = 1;

    private Integer effectValue;

    Buff(Aspect aspect, Integer duration, Integer effectValue) {
        this.aspect = aspect;
        this.duration = duration;
        this.effectValue = effectValue;
    }

    private Aspect getAspect() {
        return aspect;
    }

    Integer getEffectValue() {
        return effectValue;
    }

    private boolean isEffective() {
        return this.duration > 0;
    }

    void decreaseDuration() {
        this.duration -= 1;
    }

    public abstract void effect(People p) throws Exception;

    public static void buffOn(People currentPeople, Aspect aspect) {
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

}
