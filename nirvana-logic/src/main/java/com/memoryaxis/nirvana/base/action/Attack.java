package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface Attack extends Action {

    @Override
    default void action(People attackP, People defendP) {
        attackP.getAttackReflectionList().forEach(reflection -> {
            reflection.beforeAttack(attackP, defendP);
        });

        Integer decreaseHp = attack(attackP, defendP);

        attackP.getAttackReflectionList().forEach(reflection -> {
            reflection.afterAttack(attackP, defendP, decreaseHp);
        });
    }

    default int attack(People attackP, People defendP) {
        Integer decreaseHp = attackP.getAtk();
        defendP.decreaseHp(decreaseHp, attackP);
        return decreaseHp;
    }

    enum Attacks implements Attack {

        BASE_ATTACK,

        DOUBLE_ATTACK {
            @Override
            public int attack(People attackP, People defendP) {
                Integer decreaseHp = attackP.getAtk() * 2;
                defendP.decreaseHp(decreaseHp, attackP);
                return decreaseHp;
            }
        }
    }
}
