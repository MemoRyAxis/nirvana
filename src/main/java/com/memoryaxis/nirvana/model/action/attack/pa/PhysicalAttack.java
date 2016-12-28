package com.memoryaxis.nirvana.model.action.attack.pa;

import com.memoryaxis.nirvana.model.action.attack.Attack;
import com.memoryaxis.nirvana.model.base.People;

/**
 * Created by mz on 12/26/2016.
 */
public abstract class PhysicalAttack extends Attack {

    @Override
    protected void doAttack(People p1, People p2) throws Exception {

        Integer damage = p1.getPa();

        Integer p2hp = p2.getHp() - damage;

        p2.setHp(p2hp);

    }

}
