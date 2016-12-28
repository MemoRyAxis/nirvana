package com.memoryaxis.nirvana.model.action.treat;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.People;

/**
 * Created by mz on 12/26/2016.
 */
public abstract class Treat implements Action {

    protected void doTreat(People p1, People p2) throws Exception {

        Integer hp = p1.getMa();

        Integer p2hp = p2.getHp() + hp;

        p2.setHp(Integer.min(p2hp, p2.getFhp()));

    }

}
