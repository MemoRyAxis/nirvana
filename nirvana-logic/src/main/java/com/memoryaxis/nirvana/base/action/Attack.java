package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface Attack extends Action {

    @Override
    default void action(People attackP, People defendP) {
        Integer decreaseHp = attackP.getAtk();
        defendP.decreaseHp(decreaseHp, attackP);
    }

    enum Attacks implements Attack {

        BASE_ATTACK,

        DOUBLE_ATTACK {
            @Override
            public void action(People attackP, People defendP) {
                Integer decreaseHp = attackP.getAtk() * 2;
                defendP.decreaseHp(decreaseHp, attackP);
            }
        }
    }
}
