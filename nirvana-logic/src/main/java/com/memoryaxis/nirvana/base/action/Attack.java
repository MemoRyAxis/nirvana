package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.critical.Critical;
import com.memoryaxis.nirvana.base.effect.Effect;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface Attack extends Action, Critical {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer decreaseHp = attackP.getAtk();
        defendP.decreaseHp(decreaseHp, attackP);
        return Effect.builder()
                .decreaseHp(decreaseHp)
                .build();
    }

    @Override
    default Effect critical(People attackP, People defendP) {
        Integer decreaseHp = new BigDecimal(
                attackP.getAtk() * attackP.getCriticalDmg())
                .intValue();
        defendP.decreaseHp(decreaseHp, attackP);
        return Effect.builder()
                .decreaseHp(decreaseHp)
                .build();
    }

    enum Impl implements Attack, Critical {

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

            @Override
            public Effect critical(People attackP, People defendP) {
                Integer decreaseHp = new BigDecimal(
                        attackP.getAtk() * attackP.getCriticalDmg() * 2)
                        .intValue();
                defendP.decreaseHp(decreaseHp, attackP);
                return Effect.builder()
                        .decreaseHp(decreaseHp)
                        .build();
            }
        }
    }
}
