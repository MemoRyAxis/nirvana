package com.memoryaxis.nirvana;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public class Helper {

    static People buildWood() {
        return People.builder()
                .baseHp(10000)
                .currentHp(10000)
                .atk(1)
                .build();
    }

    // (200,23) 368
    static People buildT(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .peopleReflectionList(Lists.newArrayList(PeopleReflection.Impl.REFLECTS))
                .skill(Recovery.Impl.BASE_RECOVERY)

                .build();
    }

    // (170,28) 672
    static People buildSoldier(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .skill(Attack.Impl.DOUBLE_ATTACK)
                .attackReflectionList(Lists.newArrayList(AttackReflection.Impl.LIFE_STEAL))
                .lifeSteal(0.3D)

                .build();
    }

    // (130,30) 1035~1465
    static People buildAssassin(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .skill(Attack.Impl.DOUBLE_ATTACK)
                .criticalChance(0.5D)
                .criticalDmg(2.5D)

                .build();
    }
}
