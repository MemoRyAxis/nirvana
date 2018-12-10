package com.memoryaxis.nirvana.base;

/**
 * @author memoryaxis@gmail.com
 */
public class PeopleUtils {

    private static final int DEFAULT_MP = 0;

    private static final int MAX_MP = 100;

    private static final int MP_RECOVERY = 30;

    /**
     * 增加血量
     */
    public static void increaseHp(People people, Integer hp) {
        Integer afterHp = people.getCurrentHp() + hp;
        people.setCurrentHp(afterHp > people.getBaseHp() ? people.getBaseHp() : afterHp);
    }

    /**
     * 减少血量
     */
    public static void decreaseHp(People people, Integer hp) {
        people.setCurrentHp(people.getCurrentHp() - hp);
    }

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

    /**
     * 攻击后
     */
    public static void afterAttack(People people) {
        people.setCurrentMp(people.getCurrentMp() + MP_RECOVERY);
    }

    /**
     * 施放技能后
     */
    public static void afterSkill(People people) {
        people.setCurrentMp(DEFAULT_MP);
    }
}
