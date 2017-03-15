package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.model.action.attack.pa.AllAttack;
import com.memoryaxis.nirvana.model.action.attack.pa.SimpleAttack;
import com.memoryaxis.nirvana.model.action.buff.bu.PhysicalAttackBuffs;
import com.memoryaxis.nirvana.model.action.buff.de.AllBleedingBuffs;
import com.memoryaxis.nirvana.model.action.treat.tr.AllTreat;
import com.memoryaxis.nirvana.model.action.treat.tr.MinTreat;
import com.memoryaxis.nirvana.model.base.People;
import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;
import com.memoryaxis.nirvana.model.base.rebuild.BasePeople;
import com.memoryaxis.nirvana.model.base.rebuild.TeamRebuild;
import com.memoryaxis.nirvana.model.base.rebuild.swardman.Berserker;
import com.memoryaxis.nirvana.model.logic.Battle;
import com.memoryaxis.nirvana.model.logic.BattleRebuild;
import com.memoryaxis.nirvana.model.logic.Context;
import com.memoryaxis.nirvana.model.reflection.gain.DoubleApGain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
public class Main {

    public static void main(String[] args) {
//        a();
        b();
    }

    public static void b() {
        BasePeople p1 = new Berserker();

        TeamRebuild a = new TeamRebuild("a");
        Map<Position, BasePeople> aMap = new HashMap<>();
        aMap.put(Position.R1_LEFT, p1);
        a.setPeopleMap(aMap);

        Context.getInstance().setAttackTeam(a);

        BasePeople p2 = new Berserker();
        TeamRebuild b = new TeamRebuild("b");
        Map<Position, BasePeople> bMap = new HashMap<>();
        bMap.put(Position.R1_LEFT, p2);
        b.setPeopleMap(bMap);

        Context.getInstance().setDefenseTeam(b);

        BattleRebuild battle = (BattleRebuild) new BattleRebuild()
                .setA(a)
                .setB(b);
        battle.ready();
        battle.start();
        battle.over();

    }

    public static void a() {
        People pa = new People("pa")
                .setHp(300)
                .setFhp(300)

                .setPa(30)
                .setMa(7)
                .setSa(1)

                .setBaseAction(new SimpleAttack())
                .setSuperAction(new PhysicalAttackBuffs())
                .setSuperAction(new AllAttack())
                .setSuperAction(new AllBleedingBuffs())
                .setOnApIncrease(new DoubleApGain());
//                .setSuperAction(new AllAttack());

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
                .setHp(500)
                .setFhp(500)

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
