package com.memoryaxis.nirvana;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
import com.memoryaxis.nirvana.base.position.ActionTarget;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;
import com.memoryaxis.nirvana.base.reflection.SkillReflection;
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

    static People buildT(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .skill(Recovery.Impl.BASE_RECOVERY)
                .skillTarget(ActionTarget.Impl.TEAM_SELF)

                .peopleReflectionList(Lists.newArrayList(PeopleReflection.Impl.REFLECTS))

                .build();
    }

    static People buildSoldier(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .skill(Attack.Impl.DOUBLE_ATTACK)
                .skillTarget(ActionTarget.Impl.OPPOSITE_DEFAULT)

                .attackReflectionList(Lists.newArrayList(AttackReflection.Impl.LIFE_STEAL))
                .skillReflectionList(Lists.newArrayList(SkillReflection.Impl.LIFE_STEAL))
                .lifeSteal(0.3D)

                .build();
    }

    static People buildAssassin(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .skill(Attack.Impl.DOUBLE_ATTACK)
                .skillTarget(ActionTarget.Impl.OPPOSITE_BACK_ROW)

                .criticalChance(0.5D)
                .criticalDmg(2.5D)

                .build();
    }

    static People buildWizard(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .action(Attack.Impl.MULTIPLE_ATTACK)
                .actionTarget(ActionTarget.Impl.OPPOSITE_ALL)

                .multipleAtkDmg(0.5)
                .criticalChance(0.1D)

                .build();
    }

    static People buildWitch(int hp, int atk) {
        return People.builder()
                .baseHp(hp)
                .currentHp(hp)
                .atk(atk)

                .action(Recovery.Impl.BASE_RECOVERY)
                .actionTarget(ActionTarget.Impl.TEAM_ALL)

                .recoveryEffect(0.3D)

                .build();
    }
}
