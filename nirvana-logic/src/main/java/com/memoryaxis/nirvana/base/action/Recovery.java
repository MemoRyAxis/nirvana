package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface Recovery extends Action {

    @Override
    default void action(People attackP, People defendP) {
        Integer increaseHp = attackP.getAtk();
        attackP.increaseHp(increaseHp, attackP);
    }

    enum Recoveries implements Recovery {

        BASE_RECOVERY
    }
}
