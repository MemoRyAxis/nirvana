package com.memoryaxis.nirvana.model.action.attack;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

/**
 * Created by mz on 12/26/2016.
 */
public abstract class Attack implements Action {

    protected abstract void doAttack(People p1, People p2) throws Exception;

    protected Position getTargetPosition(Team a, Team b) throws Exception {

        Position position = a.getCurrentActionPosition();

        while (!b.getPeoples().containsKey(position)) {
            position = position.getNext();
            if (position.equals(a.getCurrentActionPosition()))
                throw new Exception("No one in target team!");
        }

        return position;
    }

}
