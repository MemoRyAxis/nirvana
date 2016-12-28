package com.memoryaxis.nirvana.model.action.attack.pa;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;

/**
 * Created by mz on 12/26/2016.
 */
public class SimpleAttack extends PhysicalAttack {

    public void action(Team a, Team b) throws Exception {
        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        if (pa == null) return;

        People pb = b.getPeoples().get(getTargetPosition(a, b));

        attack(pa, pb);

        if (pb.getHp() < 1) {
            b.getPeoples().remove(getTargetPosition(a, b));
        }
    }

}
