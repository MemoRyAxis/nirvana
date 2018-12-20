package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface Recovery extends Action {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer increaseHp = attackP.getAtk();
        attackP.increaseHp(increaseHp, attackP);
        return Effect.builder()
                .increaseHp(increaseHp)
                .build();
    }

    enum Recoveries implements Recovery {

        BASE_RECOVERY
    }
}
