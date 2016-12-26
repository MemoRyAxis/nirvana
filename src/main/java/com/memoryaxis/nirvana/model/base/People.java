package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.buff.Buff;
import com.memoryaxis.nirvana.model.buff.DeBuff;

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

    private Set<DeBuff> debuffs;

}
