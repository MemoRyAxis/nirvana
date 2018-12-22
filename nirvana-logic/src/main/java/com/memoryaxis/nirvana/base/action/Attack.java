package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface Attack extends Action {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer decreaseHp = attackP.getAtk();
        defendP.decreaseHp(decreaseHp, attackP);
        return Effect.builder()
                .decreaseHp(decreaseHp)
                .build();
    }

    enum Impl implements Attack {

        BASE_ATTACK,

        CRITICAL_ATTACK {
            @Override
            public Effect action(People attackP, People defendP) {
                Integer decreaseHp = new BigDecimal(
                        attackP.getAtk() * attackP.getCriticalDmg())
                        .intValue();
                defendP.decreaseHp(decreaseHp, attackP);
                return Effect.builder()
                        .decreaseHp(decreaseHp)
                        .build();
            }
        },

        DOUBLE_ATTACK {
            @Override
            public Effect action(People attackP, People defendP) {
                Integer decreaseHp = attackP.getAtk() * 2;
                defendP.decreaseHp(decreaseHp, attackP);
                return Effect.builder()
                        .decreaseHp(decreaseHp)
                        .build();
            }
        }
    }
}
