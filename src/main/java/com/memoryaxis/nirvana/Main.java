package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.model.action.attack.pa.AllAttack;
import com.memoryaxis.nirvana.model.action.attack.pa.SimpleAttack;
import com.memoryaxis.nirvana.model.action.treat.tr.AllTreat;
import com.memoryaxis.nirvana.model.action.treat.tr.MinTreat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;
import com.memoryaxis.nirvana.model.logic.Battle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
public class Main {

    public static void main(String[] args) throws Exception {
        People pa = new People("pa")
                .setHp(100)
                .setFhp(100)

                .setPa(30)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        People pat = new People("pat")
                .setHp(100)
                .setFhp(100)

                .setMa(10)

                .setBaseAction(new AllTreat())
                .setSuperAction(new MinTreat());

        People pb = new People("pb")
                .setHp(120)
                .setFhp(120)

                .setPa(30)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        People pb2 = new People("pb2")
                .setHp(1000)
                .setFhp(1000)

                .setPa(50)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new AllAttack());

        Team a = new Team("a");
        Map<Position, People> aMap = new HashMap<>();
        aMap.put(Position.R1_LEFT, pa);
        aMap.put(Position.R2_RIGHT, pat);
        a.setPeoples(aMap);

        Team b = new Team("b");
        Map<Position, People> bMap = new HashMap<>();
        bMap.put(Position.R1_LEFT, pb);
        bMap.put(Position.R2_RIGHT, pb2);
        b.setPeoples(bMap);

        Battle battle = new Battle()
                .setA(a)
                .setB(b);
        battle.ready();
        battle.start();
        battle.over();
    }

}
