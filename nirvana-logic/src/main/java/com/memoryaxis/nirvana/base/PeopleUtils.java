package com.memoryaxis.nirvana.base;

/**
 * @author memoryaxis@gmail.com
 */
public class PeopleUtils {

    private static final int DEFAULT_MP = 0;

    private static final int MAX_MP = 100;

    private static final int MP_RECOVERY = 30;

    public static boolean isDead(People people) {
        return people.getCurrentHp() < 0;
    }

    public static boolean haveSkill(People people) {
        return people.getHaveSkill() && people.getCurrentMp() >= MAX_MP;
    }

    public static void afterAttack(People people) {
        people.setCurrentMp(people.getCurrentHp() + MP_RECOVERY);
    }

    public static void afterSkill(People people) {
        people.setCurrentMp(DEFAULT_MP);
    }
}
