package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by mz on 12/28/2016.
 */
public class PVP implements Battle {

    private static final Logger log = LoggerFactory.getLogger(PVP.class);

    private Team a;

    private Team b;

    private boolean isStarted = false;

    public PVP setA(Team a) {
        this.a = a;
        return this;
    }

    public PVP setB(Team b) {
        this.b = b;
        return this;
    }

    private void printLog(Team a) {
        for (Map.Entry<Position, People> entry : a.getPeoples().entrySet()) {
            log.info(entry.getKey() + ": " + entry.getValue().getHp());
        }
    }

    private void start(Team a, Team b) throws Exception {

        Integer round = 0;

        while (!a.isOver()
                && !b.isOver()) {

            log.info("--- round: " + round + " start ---");
            log.info("Team a: ");
            printLog(a);
            log.info("---");
            log.info("Team b: ");
            printLog(b);
            log.info("--- round: " + round + " end ---\n");
            Thread.sleep(1000);

            round++;

            for (Position position : Position.getPositionSeq()) {
                a.setCurrentActionPosition(position);
                b.setCurrentActionPosition(position);

                try {
                    People pa = a.getPeoples().get(position);
                    if (pa != null) {
                        if (pa.getAp() != null && pa.getAp() > 100) {
                            pa.getSuperAction().action(a, b);
                            pa.setAp(pa.getAp() - 100);
                        } else {
                            pa.getBaseAction().action(a, b);
                        }
                    }

                    People pb = b.getPeoples().get(position);
                    if (pb != null) {
                        if (pb.getAp() != null && pb.getAp() > 100) {
                            pb.getSuperAction().action(a, b);
                            pb.setAp(pb.getAp() - 100);
                        } else {
                            pb.getBaseAction().action(b, a);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (b.isOver()) {
            log.info("Team a win!");
        }

        if (a.isOver()) {
            log.info("Team b win!");
        }

    }

    @Override
    public void ready() {
        // print log
        // team skill
        // etc.
    }

    @Override
    public void start() {
        try {
            if (a == null || b == null)
                throw new Exception("Start PVP fail!");

            this.start(this.a, this.b);
            this.isStarted = true;
        } catch (Exception e) {
            log.error("Start PVP fail!", e);
        }
    }

    @Override
    public void over() {
        this.isStarted = false;
        // print log
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

}
