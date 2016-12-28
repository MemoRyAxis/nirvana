package com.memoryaxis.nirvana.model.action.treat.tr;

import com.memoryaxis.nirvana.model.action.treat.Treat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Map;

/**
 * Created by mz on 12/28/2016.
 */
public class AllTreat extends Treat {

    @Override
    public void action(Team a, Team b) throws Exception {

        People pa = a.getPeoples().get(a.getCurrentActionPosition());

        for (Map.Entry<Position, People> entry : a.getPeoples().entrySet()) {
            doTreat(pa, entry.getValue());
        }

    }

}
