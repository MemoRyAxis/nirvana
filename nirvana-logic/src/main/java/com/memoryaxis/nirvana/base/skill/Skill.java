package com.memoryaxis.nirvana.base.skill;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.PeopleUtils;

/**
 * @author memoryaxis@gmail.com
 */
public interface Skill {

    void effect(People attackP, People defendP);

    enum Skills implements Skill {
        DOUBLE_ATTACK {
            @Override
            public void effect(People attackP, People defendP) {
                Integer decreaseHp = attackP.getAtk() * 2;
                PeopleUtils.decreaseHp(defendP, decreaseHp);
            }
        },

        RECOVERY {
            @Override
            public void effect(People attackP, People defendP) {
                Integer increaseHp = attackP.getAtk();
                PeopleUtils.increaseHp(attackP, increaseHp);
            }
        };
    }
}
