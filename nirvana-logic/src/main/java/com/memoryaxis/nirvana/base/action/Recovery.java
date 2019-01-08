package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface Recovery extends Action {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer increaseHp = new BigDecimal(
                attackP.getAtk() * attackP.getRecoveryEffect()).intValue();
        defendP.increaseHp(increaseHp, attackP);
        return Effect.builder()
                .increaseHp(increaseHp)
                .build();
    }

    enum Impl implements Recovery {

        BASE_RECOVERY
    }
}
