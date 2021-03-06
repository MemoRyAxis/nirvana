package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.critical.CriticalAction;
import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface Attack extends Action, CriticalAction {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer decreaseHp = attackP.getAtk();
        defendP.decreaseHp(decreaseHp, attackP);
        return Effect.builder()
                .decreaseHp(decreaseHp)
                .build();
    }

    @Override
    default Effect criticalAction(People attackP, People defendP) {
        Integer decreaseHp = new BigDecimal(
                attackP.getAtk() * attackP.getCriticalDmg())
                .intValue();
        defendP.decreaseHp(decreaseHp, attackP);
        return Effect.builder()
                .decreaseHp(decreaseHp)
                .build();
    }

    enum Impl implements Attack, CriticalAction {

        BASE_ATTACK,

        MULTIPLE_ATTACK {
            @Override
            public Effect action(People attackP, People defendP) {
                Integer decreaseHp = new BigDecimal(
                        attackP.getAtk() * attackP.getMultipleAtkDmg())
                        .intValue();
                defendP.decreaseHp(decreaseHp, attackP);
                return Effect.builder()
                        .decreaseHp(decreaseHp)
                        .build();
            }

            @Override
            public Effect criticalAction(People attackP, People defendP) {
                Integer decreaseHp = new BigDecimal(
                        attackP.getAtk() * attackP.getCriticalDmg() * attackP.getMultipleAtkDmg())
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

            @Override
            public Effect criticalAction(People attackP, People defendP) {
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
