package com.memoryaxis.nirvana.base;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.action.Action;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.CriticalReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;
import com.memoryaxis.nirvana.base.reflection.SkillReflection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@Builder
@NoArgsConstructor
public class People {

    // hp start
    @Builder.Default
    private Integer baseHp = 0;

    @Builder.Default
    private Integer currentHp = 0;

    // atk start
    @Builder.Default
    private Integer atk = 0;

    // mp start
    @Builder.Default
    private Integer defaultMp = 0;

    @Builder.Default
    private Integer currentMp = 0;

    @Builder.Default
    private Integer mpRecovery = 30;

    // action start
    @Builder.Default
    private Action action = Attack.Impl.BASE_ATTACK;

    @Builder.Default
    private Action criticalAction = Attack.Impl.CRITICAL_ATTACK;

    private Action skill;

    // critical start
    @Builder.Default
    private Double criticalChance = 0D;

    @Builder.Default
    private Double criticalDmg = 1.5D;

    // reflection start
    @Builder.Default
    private List<PeopleReflection> peopleReflectionList =
            Lists.newArrayList(PeopleReflection.Impl.BASE);

    @Builder.Default
    private List<AttackReflection> attackReflectionList =
            Lists.newArrayList(AttackReflection.Impl.BASE);

    @Builder.Default
    private List<CriticalReflection> criticalReflectionList =
            Lists.newArrayList(CriticalReflection.Impl.BASE);

    @Builder.Default
    private List<SkillReflection> skillReflectionList =
            Lists.newArrayList(SkillReflection.Impl.BASE);

    @Builder
    public People(Integer baseHp, Integer currentHp, Integer atk, Integer defaultMp, Integer currentMp, Integer mpRecovery, Action action, Action criticalAction, Action skill, Double criticalChance, Double criticalDmg, List<PeopleReflection> peopleReflectionList, List<AttackReflection> attackReflectionList, List<CriticalReflection> criticalReflectionList, List<SkillReflection> skillReflectionList) {
        this.baseHp = baseHp;
        this.currentHp = currentHp;
        this.atk = atk;
        this.defaultMp = defaultMp;
        this.currentMp = currentMp;
        this.mpRecovery = mpRecovery;
        this.action = action;
        this.criticalAction = criticalAction;
        this.skill = skill;
        this.criticalChance = criticalChance;
        this.criticalDmg = criticalDmg;
        this.peopleReflectionList = peopleReflectionList;
        this.attackReflectionList = attackReflectionList;
        this.criticalReflectionList = criticalReflectionList;
        this.skillReflectionList = skillReflectionList;
    }

    /**
     * 增加血量
     */
    public void increaseHp(Integer hp, People from) {
        this.peopleReflectionList.forEach(reflection -> reflection.beforeIncreaseHp(this, hp, from));

        Integer afterHp = this.getCurrentHp() + hp;
        this.setCurrentHp(afterHp > this.getBaseHp() ? this.getBaseHp() : afterHp);

        this.peopleReflectionList.forEach(reflection -> reflection.afterIncreaseHp(this, hp, from));
    }

    /**
     * 减少血量
     */
    public void decreaseHp(Integer hp, People from) {
        this.peopleReflectionList.forEach(reflection -> reflection.beforeDecreaseHp(this, hp, from));

        this.setCurrentHp(this.getCurrentHp() - hp);

        this.peopleReflectionList.forEach(reflection -> reflection.afterDecreaseHp(this, hp, from));
    }

    public void doAction(People defendP) {
        if (PeopleUtils.haveSkill(this)) {
            this.skillReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));

            Effect effect = this.getSkill().action(this, defendP);

            this.skillReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
        } else {
            Effect effect;

            if (PeopleUtils.haveCritical(this)) {
                this.attackReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));
                this.criticalReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));

                effect = this.getCriticalAction().action(this, defendP);

                this.criticalReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
                this.attackReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
            } else {
                this.attackReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));

                effect = this.getAction().action(this, defendP);

                this.attackReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
            }
        }
    }
}
