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

    private Action baseAction;

    private Action superAction;

    private Reflection onHpIncrease;

    private Reflection onHpDecrease;

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

    public void increaseHp(Integer hp) {
        Integer afterHp = this.hp + hp;
        this.hp = Integer.min(afterHp, this.fhp);
        // FIXME: 12/31/2016 
        // onHpIncrease.reflection();
    }

    public void decreaseHp(Integer hp) {
        Integer afterHp = this.hp - hp;
        if (afterHp < 1) {
            this.hp = 0;
            isAlive = false;
        } else {
            this.hp = afterHp;
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

    public Action getBaseAction() {
        return baseAction;
    }

    public People setBaseAction(Action baseAction) {
        this.baseAction = baseAction;
        return this;
    }

    public Action getSuperAction() {
        return superAction;
    }

    public People setSuperAction(Action superAction) {
        this.superAction = superAction;
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

    public boolean isAlive() {
        return isAlive;
    }

}
