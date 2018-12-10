package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.skill.Skill;
import com.memoryaxis.nirvana.frame.Game;
import com.memoryaxis.nirvana.frame.Round;

/**
 * @author memoryaxis@gmail.com
 */
public class App {

    public static void main(String[] args) {
        People p1 = People.builder()
                .baseHp(100)
                .currentHp(100)
                .atk(21)
                .skill(Skill.Skills.DOUBLE_ATTACK)
                .build();
        People p2 = People.builder()
                .baseHp(130)
                .currentHp(130)
                .atk(18)
                .skill(Skill.Skills.RECOVERY)
                .build();

        Game.start(new Round(p1, p2));
    }
}
