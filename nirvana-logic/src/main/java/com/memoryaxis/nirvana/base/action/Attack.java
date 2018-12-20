package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

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

    enum Attacks implements Attack {

        BASE_ATTACK,

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
