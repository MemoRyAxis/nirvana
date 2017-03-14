package com.memoryaxis.nirvana.model.base.rebuild;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.logic.GameLifecycle;
import com.memoryaxis.nirvana.model.logic.PeopleLifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 人物的基本属性
 *
 * @author memoryaxis@gmail.com
 */
public abstract class PeopleBasic extends PeopleExtend
        implements PeopleOperation, PeopleAction, PeopleReflection, PeopleLifecycle, GameLifecycle {

    // hp
    private Integer fullHealthPoint;

    private Integer healthPoint;

    // ap
    private Integer fullAttackPoint = 100;

    private Integer attackPoint = 0;

    // damage
    private Integer physicalAttack = 0;

    private Integer magicAttack = 0;

    // action
    private List<Action> baseActions = new ArrayList<>();

    private List<Action> superActions = new ArrayList<>();

    public List<Action> getBaseActions() {
        return baseActions;
    }

    public void setBaseActions(List<Action> baseActions) {
        this.baseActions = baseActions;
    }

    public List<Action> getSuperActions() {
        return superActions;
    }

    public void setSuperActions(List<Action> superActions) {
        this.superActions = superActions;
    }

    public Integer getFullHealthPoint() {
        return fullHealthPoint;
    }

    public void setFullHealthPoint(Integer fullHealthPoint) {
        this.fullHealthPoint = fullHealthPoint;
    }

    public Integer getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(Integer healthPoint) {
        this.healthPoint = healthPoint;
    }

    public Integer getFullAttackPoint() {
        return fullAttackPoint;
    }

    public void setFullAttackPoint(Integer fullAttackPoint) {
        this.fullAttackPoint = fullAttackPoint;
    }

    public Integer getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(Integer attackPoint) {
        this.attackPoint = attackPoint;
    }

    public Integer getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(Integer physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public Integer getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(Integer magicAttack) {
        this.magicAttack = magicAttack;
    }

}
