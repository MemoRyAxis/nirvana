package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class BleedingBuff extends Buff {

    private static final Logger log = LoggerFactory.getLogger(BleedingBuff.class);

    public BleedingBuff(Aspect aspect, Integer duration, Integer effectValue) {
        super(aspect, duration, effectValue);
    }

    @Override
    public void effect(People p) throws Exception {
        Integer decreasedHp = p.decreaseHp(this.getEffectValue());

        this.decreaseDuration();

        log.debug("人员[{}]失血{}", p.getName(), decreasedHp);
        if (!p.isAlive()) {
            log.debug("人员[{}]被失血效果带走", p.getName());
        }
    }
}
