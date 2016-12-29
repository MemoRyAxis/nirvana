package com.memoryaxis.nirvana.model.action.treat.tr;

import com.memoryaxis.nirvana.model.action.treat.Treat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Map;

/**
 * Created by mz on 12/29/2016.
 */
public class MinTreat extends Treat {

    @Override
    public void action(Team a, Team b) throws Exception {

        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        Position minPosition = Position.R1_LEFT;
        Integer minHp = Integer.MAX_VALUE;

        for (Map.Entry<Position, People> entry : a.getPeoples().entrySet()) {
            if (entry.getValue().getHp() < minHp) {
                minHp = entry.getValue().getHp();
                minPosition = entry.getKey();
            }
        }

        doTreat(pa, a.getPeoples().get(minPosition));

    }

}
