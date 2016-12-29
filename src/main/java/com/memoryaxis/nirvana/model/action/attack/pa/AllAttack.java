package com.memoryaxis.nirvana.model.action.attack.pa;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by mz on 12/29/2016.
 */
public class AllAttack extends PhysicalAttack {

    @Override
    public void action(Team a, Team b) throws Exception {
        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        if (pa == null) return;

        Iterator<Map.Entry<Position, People>> iterator = b.getPeoples().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Position, People> entry = iterator.next();

            People pb = entry.getValue();

            doAttack(pa, pb);

            if (pb.getHp() < 1) {
                iterator.remove();
            }
        }


    }

}
