package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.model.action.attack.pa.AllAttack;
import com.memoryaxis.nirvana.model.action.attack.pa.SimpleAttack;
import com.memoryaxis.nirvana.model.action.treat.tr.AllTreat;
import com.memoryaxis.nirvana.model.action.treat.tr.MinTreat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;
import com.memoryaxis.nirvana.model.logic.PVP;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc main class
 * @date 24th Dec. 2016
 */
public class Main {

    public static void main(String[] args) throws Exception {
        People pa = new People()
                .setHp(100)
                .setFhp(100)

                .setPa(30)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        People pat = new People()
                .setHp(100)
                .setFhp(100)

                .setMa(10)

                .setBaseAction(new AllTreat())
                .setSuperAction(new MinTreat());

        People pb = new People()
                .setHp(120)
                .setFhp(120)

                .setPa(30)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        People pb2 = new People()
                .setHp(1000)
                .setFhp(1000)

                .setPa(50)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        Team a = new Team();
        Map<Position, People> aMap = new HashMap<>(1);
        aMap.put(Position.R1_LEFT, pa);
        aMap.put(Position.R2_RIGHT, pat);
        a.setPeoples(aMap);

        Team b = new Team();
        Map<Position, People> bMap = new HashMap<>(1);
        bMap.put(Position.R1_LEFT, pb);
        bMap.put(Position.R2_RIGHT, pb2);
        b.setPeoples(bMap);

        new PVP().setA(a)
                .setB(b)
                .start();

    }

}
