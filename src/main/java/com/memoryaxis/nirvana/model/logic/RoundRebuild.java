package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;
import com.memoryaxis.nirvana.model.base.rebuild.BasePeople;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class RoundRebuild extends Round {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoundRebuild.class);

    private Context getContext() {
        return Context.getInstance();
    }

    RoundRebuild(int currentRound) {
        super(currentRound);
    }

    @Override
    public void start() {
        try {
            for (Position position : Position.getPositionSeq()) {

                Team attackTeam = getContext().getAttackTeam();
                Team defenceTeam = getContext().getDefenseTeam();

                for (int i = 0; i < 2; i++) {
                    BasePeople p = attackTeam.getPeoples().get(position);
                    attackTeam.setCurrentActionPosition(position);
                    if (p != null) {
                        Bout bout = new BoutRebuild(p)
                                .setA(attackTeam)
                                .setB(defenceTeam);
                        bout.ready();
                        bout.start();
                        bout.over();
                    }

                    getContext().setAttackTeam(getContext().getDefenseTeam());
                    getContext().setDefenseTeam(getContext().getAttackTeam());
                }
            }
        } catch (Exception e) {
            LOGGER.error("Start Round Fail!", e);
        }
    }

}
