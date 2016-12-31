package com.memoryaxis.nirvana.model.action.buff.de;

import com.memoryaxis.nirvana.model.action.buff.Buffs;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.buff.Aspect;
import com.memoryaxis.nirvana.model.base.buff.BleedingBuff;
import com.memoryaxis.nirvana.model.base.buff.Buff;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
public class AllBleedingBuffs extends Buffs {

    @Override
    public void action(Team a, Team b) throws Exception {
        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        if (pa == null) return;

        Buff buff = new BleedingBuff(Aspect.BOUT_READY, 3, pa.getSa());

        for (Map.Entry<Position, People> entry : b.getPeoples().entrySet()) {
            addBuff(null, entry.getValue(), buff);
        }
    }

}
