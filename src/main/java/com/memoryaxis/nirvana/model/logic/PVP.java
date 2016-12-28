package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.action.attack.pa.SimpleAttack;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mz on 12/28/2016.
 */
public class PVP implements Battle {

    @Override
    public void start(Team a, Team b) {

        while (!a.isOver()
                && !b.isOver()) {
            for (Position position : Position.getPositionSeq()) {
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
            System.out.println(a.getPeoples());
        }

        if (a.isOver()) {
            System.out.println("Team b win!");
            System.out.println(b.getPeoples());
        }

    }

    public static void main(String[] args) {
        People pa = new People();
        pa.setHp(90);
        pa.setPa(30);
        pa.setBaseAction(new SimpleAttack());

        People pb = new People();
        pb.setHp(120);
        pb.setPa(30);
        pb.setBaseAction(new SimpleAttack());

        Team a = new Team();
        Map<Position, People> aMap = new HashMap<>(1);
        aMap.put(Position.R1_LEFT, pa);
        a.setPeoples(aMap);

        Team b = new Team();
        Map<Position, People> bMap = new HashMap<>(1);
        bMap.put(Position.R1_LEFT, pb);
        b.setPeoples(bMap);

        new PVP().start(a, b);

    }

}
