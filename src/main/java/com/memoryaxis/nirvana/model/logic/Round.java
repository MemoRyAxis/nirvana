package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class Round implements Lifecycle {

    private static final Logger log = LoggerFactory.getLogger(Round.class);

    private Team a;

    private Team b;

    private boolean isStarted = false;

    private final int currentRound;

    Round(int currentRound) {
        this.currentRound = currentRound;
    }

    public Round setA(Team a) {
        this.a = a;
        return this;
    }

    public Round setB(Team b) {
        this.b = b;
        return this;
    }

    @Override
    public void ready() {
        a.printInfo();
        b.printInfo();
        log.info("Round {} Start.", currentRound);

        // print log
        // buffs
        // etc.
    }

    @Override
    public void start() {
        try {
            this.isStarted = true;

            // TODO: 12/30/2016 Attack Speed
            for (Position position : Position.getPositionSeq()) {
                for (Team[] teamPair : new Team[][]{{a, b}, {b, a}}) {
                    Team attackTeam = teamPair[0];
                    Team defenceTeam = teamPair[1];

                    People p = attackTeam.getPeoples().get(position);
                    attackTeam.setCurrentActionPosition(position);
                    if (p != null) {
                        Bout bout = new Bout()
                                .setCurrentPeople(p)
                                .setA(attackTeam)
                                .setB(defenceTeam);
                        bout.ready();
                        bout.start();
                        bout.over();
                    }
                }
            }
        } catch (Exception e) {
            log.error("Start Round Fail!", e);
        }
    }

    @Override
    public void over() {
        this.isStarted = false;

        // print log
        // people skill
        // buffs

        log.info("Round {} End.\n", currentRound);
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

}
