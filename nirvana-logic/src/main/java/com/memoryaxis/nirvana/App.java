package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.Team;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.action.Recovery;
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
        People p1 = People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Attack.Attacks.DOUBLE_ATTACK)
                .reflection(Reflection.Reflections.LIFE_STEAL)
                .build();
        People p2 = People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Recovery.Recoveries.BASE_RECOVERY)
                .reflection(Reflection.Reflections.LIFE_STEAL)
                .build();

        Team t1 = new Team(p1, p1, p1, p2, p2, p2);
        Team t2 = new Team(p2, p2, p2, p1, p1, p1);

        TeamGame.start(new TeamRound(t1, t2));
    }

    private static void startGame() {
        People p1 = People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Attack.Attacks.DOUBLE_ATTACK)
                .reflection(Reflection.Reflections.LIFE_STEAL)
                .build();
        People p2 = People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .action(Attack.Attacks.BASE_ATTACK)
                .skill(Recovery.Recoveries.BASE_RECOVERY)
                .reflection(Reflection.Reflections.REFLECTS)
                .build();

        Game.start(new Round(p1, p2));
    }
}
