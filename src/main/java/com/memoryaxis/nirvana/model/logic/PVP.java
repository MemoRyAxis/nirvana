package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.action.attack.pa.SimpleAttack;
import com.memoryaxis.nirvana.model.action.treat.tr.AllTreat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mz on 12/28/2016.
 */
public class PVP implements Battle {

    private void printLog(Team a) {
        for (Map.Entry<Position, People> entry : a.getPeoples().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getHp());
        }
    }

    @Override
    public void start(Team a, Team b) throws Exception {

        Integer round = 0;

        while (!a.isOver()
                && !b.isOver()) {

            System.out.println("--- round: " + round + " start ---");
            System.out.println("Team a: ");
            printLog(a);
            System.out.println("---");
            System.out.println("Team b: ");
            printLog(b);
            System.out.println("--- round: " + round + " end ---\n");
            Thread.sleep(1000);

            round++;

            for (Position position : Position.getPositionSeq()) {
                a.setCurrentActionPosition(position);
                b.setCurrentActionPosition(position);

                try {
                    People pa = a.getPeoples().get(position);
                    if (pa != null) {
                        pa.getBaseAction().action(a, b);
                    }
                    People pb = b.getPeoples().get(position);
                    if (pb != null) {
                        pb.getBaseAction().action(b, a);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (b.isOver()) {
            System.out.println("Team a win!");
        }

        if (a.isOver()) {
            System.out.println("Team b win!");
        }

    }

    public static void main(String[] args) throws Exception {
        People pa = new People();
        pa.setHp(90);
        pa.setFhp(90);
        pa.setPa(30);
        pa.setBaseAction(new SimpleAttack());

        People pat = new People();
        pat.setMa(10);
        pat.setHp(90);
        pat.setFhp(90);
        pat.setBaseAction(new AllTreat());

        People pb = new People();
        pb.setHp(120);
        pb.setPa(30);
        pb.setBaseAction(new SimpleAttack());

        Team a = new Team();
        Map<Position, People> aMap = new HashMap<>(1);
        aMap.put(Position.R1_LEFT, pa);
        aMap.put(Position.R2_RIGHT, pat);
        a.setPeoples(aMap);

        Team b = new Team();
        Map<Position, People> bMap = new HashMap<>(1);
        bMap.put(Position.R1_LEFT, pb);
        b.setPeoples(bMap);

        new PVP().start(a, b);

    }

}
