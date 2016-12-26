package com.memoryaxis.nirvana.model.action.attack.pa;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;

/**
 * Created by mz on 12/26/2016.
 */
public class SimpleAttack extends PhysicalAttack {

    public void action(Team a, Team b) throws Exception {
        People people = a.getPeoples().getOrDefault(a.getCurrentActionPosition(), null);

        if (people == null) return;

        doAttack(people, b.getPeoples().get(getTargetPosition(a, b)));
    }

}
