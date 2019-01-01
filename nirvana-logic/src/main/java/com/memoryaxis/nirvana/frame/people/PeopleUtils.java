package com.memoryaxis.nirvana.frame.people;

import com.memoryaxis.nirvana.base.critical.PeopleCritical;
import com.memoryaxis.nirvana.utils.Randoms;

/**
 * @author memoryaxis@gmail.com
 */
public class PeopleUtils {

    private static final int MAX_MP = 100;

    public static String getPeopleInfo(People people) {
        if (people == null) {
            return "-";
        } else if (isDead(people)) {
            return "DEAD";
        } else {
            return people.getCurrentHp()
                    + "/"
                    + people.getBaseHp()
                    + "("
                    + people.getAtk()
                    + ")";
        }
    }

    public static int getPeopleHp(People people) {
        if (people == null) {
            return 0;
        }
        return people.getCurrentHp();
    }

    /**
     * 是否已阵亡
     */
    public static boolean isDead(People people) {
        return getPeopleHp(people) <= 0;
    }

    /**
     * 是否有技能待施放
     */
    public static boolean haveSkill(People people) {
        return people.getSkill() != null
                && people.getSkillTarget() != null
                && people.getCurrentMp() >= MAX_MP;
    }

    public static boolean haveActionCritical(People people) {
        return people.getAction() instanceof PeopleCritical
                && haveCriticalChance(people);
    }

    public static boolean haveSkillCritical(People people) {
        return people.getAction() instanceof PeopleCritical
                && haveCriticalChance(people);
    }

    private static boolean haveCriticalChance(People people) {
        return Randoms.randomChange(people.getCriticalChance());
    }
}
