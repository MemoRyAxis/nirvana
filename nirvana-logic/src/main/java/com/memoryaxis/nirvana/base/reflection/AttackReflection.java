package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface AttackReflection extends ActionReflection {

    AttackReflection defaultReflection = new AttackReflectionDefault();

    default void beforeAction(People attackP, People defendP) {
    }

    default void afterAction(People attackP, People defendP, Effect effect) {
    }

    enum AttackReflections implements AttackReflection {
        LIFE_STEAL {
            @Override
            public void afterAction(People attackP, People defendP, Effect effect) {
                Integer stealHp = new BigDecimal(effect.getDecreaseHp() * 0.3).intValue();
                attackP.increaseHp(stealHp, defendP);

                defaultReflection.afterAction(attackP, defendP, effect);
            }
        }
    }
}

class AttackReflectionDefault implements AttackReflection {
    @Override
    public void afterAction(People attackP, People defendP, Effect effect) {
        attackP.setCurrentMp(attackP.getCurrentMp() + attackP.getMpRecovery());
    }
}