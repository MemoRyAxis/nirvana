package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public abstract class Buff {

    private Aspect aspect = Aspect.AT_ONCE;

    private Integer duration = 1;

    private Integer effectValue;

    Buff(Aspect aspect, Integer duration, Integer effectValue) {
        this.aspect = aspect;
        this.duration = duration;
        this.effectValue = effectValue;
    }

    public Aspect getAspect() {
        return aspect;
    }

    Integer getEffectValue() {
        return effectValue;
    }

    public boolean isEffective() {
        return this.duration > 0;
    }

    protected void decreaseDuration() {
        this.duration -= 1;
    }

    public abstract void effect(People p) throws Exception;

}
