package com.memoryaxis.nirvana.model.action.attack;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

/**
 * Created by mz on 12/26/2016.
 */
public abstract class Attack implements Action {

    abstract void action(Team a, Team b) throws Exception;

    public void doAttack(People p1, People p2) throws Exception {

    }

    public Position getTargetPosition(Team a, Team b) throws Exception {
        for (Position position : Position.getPositionSeq(a.getCurrentActionPosition())) {
            if (b.getPeoples().containsKey(position)) {
                return position;
            }
        }
        throw new Exception("Target Team Has No One!");
    }

}
