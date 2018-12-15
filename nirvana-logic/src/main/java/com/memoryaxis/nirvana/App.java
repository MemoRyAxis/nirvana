package com.memoryaxis.nirvana;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.Team;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.Reflection;
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
        Team t1 = new Team("T1", buildP1(), buildP1(), buildP1());
        Team t2 = new Team("T2", buildP2(), buildP2(), buildP2());
//        Team t1 = new Team("T1", buildP1(), buildP1());
//        Team t2 = new Team("T2", null, buildP2(), buildP2());

        TeamGame.start(new TeamRound(t1, t2));
    }

    private static void startGame() {
        People p1 = People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Attack.Attacks.DOUBLE_ATTACK)
                .build();
        People p2 = People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Recovery.Recoveries.BASE_RECOVERY)
                .reflection(Reflection.Reflections.REFLECTS)
                .attackReflectionList(Lists.newArrayList(AttackReflection.AttackReflections.LIFE_STEAL))
                .build();

        Game.start(new Round(p1, p2));
    }

    private static People buildP1() {
        return People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .action(Attack.Attacks.BASE_ATTACK)
//                .skill(Attack.Attacks.DOUBLE_ATTACK)
                .attackReflectionList(Lists.newArrayList(AttackReflection.AttackReflections.LIFE_STEAL))
                .build();
    }

    private static People buildP2() {
        return People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .action(Attack.Attacks.DOUBLE_ATTACK)
//                .skill(Attack.Attacks.DOUBLE_ATTACK)
//                .skill(Recovery.Recoveries.BASE_RECOVERY)
                .build();
    }
}
