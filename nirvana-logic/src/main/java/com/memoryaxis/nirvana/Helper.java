package com.memoryaxis.nirvana;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;

/**
 * @author memoryaxis@gmail.com
 */
public class Helper {

    static People buildT(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)
                .peopleReflectionList(Lists.newArrayList(PeopleReflection.Impl.REFLECTS))
                .skill(Recovery.Impl.BASE_RECOVERY)
                .build();
    }

    static People buildSoldier(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)
                .skill(Attack.Impl.DOUBLE_ATTACK)
                .attackReflectionList(Lists.newArrayList(AttackReflection.Impl.LIFE_STEAL))
                .build();
    }

    static People buildAssassin(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)
                .criticalChance(0.5D)
                .criticalDmg(2.5D)
                .build();
    }
}
