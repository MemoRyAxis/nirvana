package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public abstract class Buff {

    private Aspect aspect;

    private Integer duration;

    private Integer effectValue;

    Buff(Aspect aspect, Integer duration, Integer effectValue) {
        this.aspect = aspect;
        this.duration = duration;
        this.effectValue = effectValue;
    }

    public Aspect getAspect() {
        return aspect;
    }

    public Integer getDuration() {
        return duration;
    }

    Integer getEffectValue() {
        return effectValue;
    }

    public abstract void effect(People p) throws Exception;

}
