package com.memoryaxis.nirvana.base;

import com.memoryaxis.nirvana.base.action.Action;
import com.memoryaxis.nirvana.base.reflection.Reflection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@Builder
@NoArgsConstructor
public class People {

    @Builder.Default
    private Integer baseHp = 0;

    @Builder.Default
    private Integer currentHp = 0;

    @Builder.Default
    private Integer atk = 0;

    @Builder.Default
    private Integer currentMp = 0;

    private Action action;

    private Action skill;

    @Builder.Default
    private Reflection reflection = Reflection.Reflections.BASE_REFLECTION;

    @Builder
    public People(Integer baseHp, Integer currentHp, Integer atk, Integer currentMp, Action action, Action skill, Reflection reflection) {
        this.baseHp = baseHp;
        this.currentHp = currentHp;
        this.atk = atk;
        this.currentMp = currentMp;
        this.action = action;
        this.skill = skill;
        this.reflection = reflection;
    }


    //
    private static final int DEFAULT_MP = 0;

    private static final int MP_RECOVERY = 30;

    /**
     * 增加血量
     */
    public void increaseHp(Integer hp, People from) {
        this.reflection.beforeIncreaseHp(this, hp, from);

        Integer afterHp = this.getCurrentHp() + hp;
        this.setCurrentHp(afterHp > this.getBaseHp() ? this.getBaseHp() : afterHp);

        this.reflection.afterIncreaseHp(this, hp, from);
    }

    /**
     * 减少血量
     */
    public void decreaseHp(Integer hp, People from) {
        this.reflection.beforeDecreaseHp(this, hp, from);

        this.setCurrentHp(this.getCurrentHp() - hp);

        this.reflection.afterDecreaseHp(this, hp, from);
    }

    // TODO
    public void attack(People defendPeople) {
        if (PeopleUtils.haveSkill(this)) {
            this.getSkill().action(this, defendPeople);
            this.afterSkill();
        } else {
            this.getAction().action(this, defendPeople);
            this.afterAttack();
        }
    }

    /**
     * 攻击后
     */
    public void afterAttack() {
        this.setCurrentMp(this.getCurrentMp() + MP_RECOVERY);

        this.reflection.afterAction(this);
    }

    /**
     * 施放技能后
     */
    public void afterSkill() {
        this.setCurrentMp(DEFAULT_MP);
    }
}

