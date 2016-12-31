package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.buff.Buff;
import com.memoryaxis.nirvana.model.reflection.Reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
public class People {

    private final String name;

    private boolean isAlive = true;

    // ---

    // fullHealthPoint
    private Integer fhp;

    // healthPoint
    private Integer hp;

    // fullMagicPoint
//    private Integer fmp;

    // magicPoint
//    private Integer mp;

    // attachPoint
    private Integer ap = 0;


    // physicalAttack
    private Integer pa = 0;

    // magicAttack
    private Integer ma = 0;

    // specialAttack
    private Integer sa = 0;

    // hitRate
//    private Integer hr;

    // parryRate
//    private Integer pr;


    // physicalKnockRate
//    private Integer pkr;

    // magicKnockRate
//    private Integer mkr;


    // physicalAttackSpeed
//    private Integer pas;

    // magicAttackSpeed
//    private Integer mas;


    // physicalDefense
//    private Integer pd;

    // magicDefense
//    private Integer md;

    private List<Action> baseActions = new ArrayList<>();

    private List<Action> superActions = new ArrayList<>();

    private Reflection onHpIncrease = p -> {
    };

    private Reflection onHpDecrease = p -> {
    };

    private Reflection onApIncrease = p -> {
    };

    private Reflection onApDecrease = p -> {
    };

    private List<Buff> buffs = new ArrayList<>();

    public People(String name) {
        this.name = name;
    }

    public Integer getFhp() {
        return fhp;
    }

    public People setFhp(Integer fhp) {
        this.fhp = fhp;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public People setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Integer increaseHp(Integer hp) {
        Integer beforeHp = this.hp;
        Integer afterHp = this.hp + hp;
        this.hp = Integer.min(afterHp, this.fhp);

        return this.getHp() - beforeHp;
        // FIXME: 12/31/2016 
        // onHpIncrease.reflection();
    }

    public Integer decreaseHp(Integer hp) {
        Integer beforeHp = this.hp;
        Integer afterHp = this.hp - hp;
        if (afterHp < 1) {
            this.hp = 0;
            isAlive = false;
            return beforeHp;
        } else {
            this.hp = afterHp;
            return hp;
            // FIXME: 12/31/2016
            // onHpDecrease.reflection();
        }
    }

    public Integer getAp() {
        return ap;
    }

    public People setAp(Integer ap) {
        this.ap = ap;
        return this;
    }

    public void increaseAp(Integer ap) {
        this.ap += ap;
        this.onApIncrease.reflection(this);
    }

    public void decreaseAp(Integer ap) {
        this.ap -= ap;
    }

    public Integer getPa() {
        return pa;
    }

    public People setPa(Integer pa) {
        this.pa = pa;
        return this;
    }

    public Integer getMa() {
        return ma;
    }

    public People setMa(Integer ma) {
        this.ma = ma;
        return this;
    }

    public Integer getSa() {
        return sa;
    }

    public People setSa(Integer sa) {
        this.sa = sa;
        return this;
    }

    public List<Action> getBaseActions() {
        return baseActions;
    }

    public List<Action> getSuperActions() {
        return superActions;
    }

    public People setBaseAction(Action baseAction) {
        this.baseActions.add(baseAction);
        return this;
    }

    public People setSuperAction(Action superAction) {
        this.superActions.add(superAction);
        return this;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public People setBuffs(List<Buff> buffs) {
        this.buffs = buffs;
        return this;
    }

    public String getName() {
        return name;
    }

    public Reflection getOnHpIncrease() {
        return onHpIncrease;
    }

    public People setOnHpIncrease(Reflection onHpIncrease) {
        this.onHpIncrease = onHpIncrease;
        return this;
    }

    public Reflection getOnHpDecrease() {
        return onHpDecrease;
    }

    public People setOnHpDecrease(Reflection onHpDecrease) {
        this.onHpDecrease = onHpDecrease;
        return this;
    }

    public Reflection getOnApIncrease() {
        return onApIncrease;
    }

    public People setOnApIncrease(Reflection onApIncrease) {
        this.onApIncrease = onApIncrease;
        return this;
    }

    public People setOnApDecrease(Reflection onApDecrease) {
        this.onApDecrease = onApDecrease;
        return this;
    }

    public Reflection getOnApDecrease() {
        return onApDecrease;
    }

    public boolean isAlive() {
        return isAlive;
    }

}
