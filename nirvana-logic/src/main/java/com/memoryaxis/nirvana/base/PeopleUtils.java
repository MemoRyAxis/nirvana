package com.memoryaxis.nirvana.base;

/**
 * @author memoryaxis@gmail.com
 */
public class PeopleUtils {

    private static final int MAX_MP = 100;

    /**
     * 是否已阵亡
     */
    public static boolean isDead(People people) {
        return people.getCurrentHp() < 0;
    }

    /**
     * 是否有技能待施放
     */
    public static boolean haveSkill(People people) {
        return people.getSkill() != null
                && people.getCurrentMp() >= MAX_MP;
    }
}
