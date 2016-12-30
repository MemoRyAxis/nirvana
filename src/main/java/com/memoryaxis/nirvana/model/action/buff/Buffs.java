package com.memoryaxis.nirvana.model.action.buff;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.buff.Buff;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
public abstract class Buffs implements Action {

    protected void addBuff(People p1, People p2, Buff buff) throws Exception {

        List<Buff> buffs = p2.getBuffs();

        buffs.add(buff);
    }

}


