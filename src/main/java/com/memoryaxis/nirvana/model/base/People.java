package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.buff.Buff;
import com.memoryaxis.nirvana.model.buff.Debuff;

import java.util.Set;

/**
 * Created by mz on 12/24/2016.
 */
public class People {

    // healthPoint
    private Integer hp;

    // magicPoint
    private Integer mp;

    // attachPoint
    private Integer ap;


    // physicalAttack
    private Integer pa;

    // magicAttack
    private Integer ma;


    // hitRate
    private Integer hr;

    // parryRate
    private Integer pr;


    // physicalKnockRate
    private Integer pkr;

    // magicKnockRate
    private Integer mkr;


    // physicalAttackSpeed
    private Integer pas;

    // magicAttackSpeed
    private Integer mas;


    // physicalDefense
    private Integer pd;

    // magicDefense
    private Integer md;

    private Set<Buff> buffs;

    private Set<Debuff> debuffs;


    private Action baseAction;

    private Action superAction;


    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    public Integer getPa() {
        return pa;
    }

    public void setPa(Integer pa) {
        this.pa = pa;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getHr() {
        return hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }

    public Integer getPr() {
        return pr;
    }

    public void setPr(Integer pr) {
        this.pr = pr;
    }

    public Integer getPkr() {
        return pkr;
    }

    public void setPkr(Integer pkr) {
        this.pkr = pkr;
    }

    public Integer getMkr() {
        return mkr;
    }

    public void setMkr(Integer mkr) {
        this.mkr = mkr;
    }

    public Integer getPas() {
        return pas;
    }

    public void setPas(Integer pas) {
        this.pas = pas;
    }

    public Integer getMas() {
        return mas;
    }

    public void setMas(Integer mas) {
        this.mas = mas;
    }

    public Integer getPd() {
        return pd;
    }

    public void setPd(Integer pd) {
        this.pd = pd;
    }

    public Integer getMd() {
        return md;
    }

    public void setMd(Integer md) {
        this.md = md;
    }

    public Set<Buff> getBuffs() {
        return buffs;
    }

    public void setBuffs(Set<Buff> buffs) {
        this.buffs = buffs;
    }

    public Set<Debuff> getDebuffs() {
        return debuffs;
    }

    public void setDebuffs(Set<Debuff> debuffs) {
        this.debuffs = debuffs;
    }

    public Action getBaseAction() {
        return baseAction;
    }

    public void setBaseAction(Action baseAction) {
        this.baseAction = baseAction;
    }

    public Action getSuperAction() {
        return superAction;
    }

    public void setSuperAction(Action superAction) {
        this.superAction = superAction;
    }

}
