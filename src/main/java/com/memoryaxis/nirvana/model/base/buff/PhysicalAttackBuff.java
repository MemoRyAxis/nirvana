package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public class PhysicalAttackBuff extends Buff {

    public PhysicalAttackBuff(Aspect aspect, Integer duration, Integer effectValue) {
        super(aspect, duration, effectValue);
    }

    @Override
    public void effect(People p) throws Exception {
        p.setPa(p.getPa() + this.getEffectValue());
    }

}
