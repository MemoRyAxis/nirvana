package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface Recovery extends PeopleAction {

    @Override
    default Effect action(People attackP, People defendP) {
        Integer increaseHp = attackP.getAtk();
        attackP.increaseHp(increaseHp, attackP);
        return Effect.builder()
                .increaseHp(increaseHp)
                .build();
    }

    enum Impl implements Recovery {

        BASE_RECOVERY
    }
}
