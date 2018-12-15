package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface AttackReflection {

    default void beforeAttack(People attackP, People defendP) {

    }

    default void afterAttack(People attackP, People defendP, Integer decreaseHp) {

    }

    enum AttackReflections implements AttackReflection {
        LIFE_STEAL {
            @Override
            public void afterAttack(People attackP, People defendP, Integer decreaseHp) {
                Integer stealHp = new BigDecimal(decreaseHp * 0.3).intValue();
                attackP.increaseHp(stealHp, defendP);
            }
        }
    }
}
