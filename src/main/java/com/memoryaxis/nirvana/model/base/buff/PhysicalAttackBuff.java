package com.memoryaxis.nirvana.model.base.buff;

import com.memoryaxis.nirvana.model.base.People;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class PhysicalAttackBuff extends Buff {

    private static final Logger log = LoggerFactory.getLogger(PhysicalAttackBuff.class);

    public PhysicalAttackBuff(Aspect aspect, Integer duration, Integer effectValue) {
        super(aspect, duration, effectValue);
    }

    @Override
    public void effect(People p) throws Exception {
        p.setPa(p.getPa() + this.getEffectValue());

        this.decreaseDuration();

        log.debug("人员[{}]增加物理攻击力{}", p.getName(), this.getEffectValue());
    }

}
