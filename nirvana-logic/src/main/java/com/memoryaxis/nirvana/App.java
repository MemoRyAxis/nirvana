package com.memoryaxis.nirvana;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.Team;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;
import com.memoryaxis.nirvana.frame.Game;
import com.memoryaxis.nirvana.frame.Round;
import com.memoryaxis.nirvana.frame.TeamGame;
import com.memoryaxis.nirvana.frame.TeamRound;

/**
 * @author memoryaxis@gmail.com
 */
public class App {

    public static void main(String[] args) {
//        startGame();
        startTeamGame();
    }

    private static void startTeamGame() {
//        Team t1 = new Team("T1", buildP1(), buildP1(), buildP1(), buildP2(), buildP2(), buildP2());
//        Team t2 = new Team("T2", buildP2(), buildP2(), buildP2(), buildP1(), buildP1(), buildP1());
//        Team t1 = new Team("T1", buildP1(), buildP1(), buildP1());
//        Team t2 = new Team("T2", buildP2(), buildP2(), buildP2());
//        Team t1 = new Team("T1", buildP1(), buildP1());
//        Team t2 = new Team("T2", null, buildP2(), buildP2());

        Team t1 = new Team("T1",
                bat(),
                bat(),
                bat());
        Team t2 = new Team("T2",
                bas(),
                bas(),
                bas());
        Team t3 = new Team("T3",
                baa(),
                baa(),
                baa());

//        TeamGame.start(new TeamRound(t1, t2));
//        TeamGame.start(new TeamRound(t2, t3));
        TeamGame.start(new TeamRound(t1, t3));
    }

    private static People bat() {
        return Helper.buildT(200, 15);
    }

    private static People bas() {
        return Helper.buildSoldier(150, 30);
    }

    private static People baa() {
        return Helper.buildAssassin(130, 32);
    }

    private static void startGame() {
        People p1 = People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .action(Attack.Impl.BASE_ATTACK)
                .skill(Attack.Impl.DOUBLE_ATTACK)
                .build();
        People p2 = People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .action(Attack.Impl.BASE_ATTACK)
                .skill(Recovery.Impl.BASE_RECOVERY)
                .peopleReflectionList(Lists.newArrayList(PeopleReflection.Impl.REFLECTS))
                .attackReflectionList(Lists.newArrayList(AttackReflection.Impl.LIFE_STEAL))
                .build();

        Game.start(new Round(p1, p2));
    }
}
