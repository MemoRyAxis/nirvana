package com.memoryaxis.nirvana.model.action.buff.bu;

import com.memoryaxis.nirvana.model.action.buff.Buffs;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.buff.Aspect;
import com.memoryaxis.nirvana.model.base.buff.Buff;
import com.memoryaxis.nirvana.model.base.buff.PhysicalAttackBuff;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
public class PhysicalAttackBuffs extends Buffs {

    @Override
    public void action(Team a, Team b) throws Exception {
        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        if (pa == null) return;

        // TODO: 12/30/2016 effect at once
        Buff buff = new PhysicalAttackBuff(Aspect.BOUT_READY, 1, pa.getMa());

        for (Map.Entry<Position, People> entry : a.getPeoples().entrySet()) {
            addBuff(pa, entry.getValue(), buff);
        }
    }

}
