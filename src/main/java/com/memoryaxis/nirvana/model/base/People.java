package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.buff.Buff;

import java.io.Serializable;
import java.util.Set;

/**
 * @author memoryaxis@gmail.com
 */
public class People implements Cloneable, Serializable {

    private static int ID = 1;

    private String getId() {
        return String.valueOf(ID++);
    }

    private String name = getId();

    // ---

    // fullHealthPoint
    private Integer fhp;

    // healthPoint
    private Integer hp;

    // fullMagicPoint
    private Integer fmp;

    // magicPoint
    private Integer mp;

    // attachPoint
    private Integer ap = 0;


    // physicalAttack
    private Integer pa = 0;

    // magicAttack
    private Integer ma = 0;


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

    private Action baseAction;

    private Action superAction;

    private Set<Buff> buffs;

    public Integer getFhp() {
        return fhp;
    }

    public People setFhp(Integer fhp) {
        this.fhp = fhp;
        return this;
    }

    public Integer getFmp() {
        return fmp;
    }

    public People setFmp(Integer fmp) {
        this.fmp = fmp;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public People setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Integer getMp() {
        return mp;
    }

    public People setMp(Integer mp) {
        this.mp = mp;
        return this;
    }

    public Integer getAp() {
        return ap;
    }

    public People setAp(Integer ap) {
        this.ap = ap;
        return this;
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

    public Integer getHr() {
        return hr;
    }

    public People setHr(Integer hr) {
        this.hr = hr;
        return this;
    }

    public Integer getPr() {
        return pr;
    }

    public People setPr(Integer pr) {
        this.pr = pr;
        return this;
    }

    public Integer getPkr() {
        return pkr;
    }

    public People setPkr(Integer pkr) {
        this.pkr = pkr;
        return this;
    }

    public Integer getMkr() {
        return mkr;
    }

    public People setMkr(Integer mkr) {
        this.mkr = mkr;
        return this;
    }

    public Integer getPas() {
        return pas;
    }

    public People setPas(Integer pas) {
        this.pas = pas;
        return this;
    }

    public Integer getMas() {
        return mas;
    }

    public People setMas(Integer mas) {
        this.mas = mas;
        return this;
    }

    public Integer getPd() {
        return pd;
    }

    public People setPd(Integer pd) {
        this.pd = pd;
        return this;
    }

    public Integer getMd() {
        return md;
    }

    public People setMd(Integer md) {
        this.md = md;
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

    public Set<Buff> getBuffs() {
        return buffs;
    }

    public People setBuffs(Set<Buff> buffs) {
        this.buffs = buffs;
        return this;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

}
