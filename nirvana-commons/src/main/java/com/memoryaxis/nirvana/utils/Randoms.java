package com.memoryaxis.nirvana.utils;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public class Randoms {

    public static Integer randomWithRange(Integer value, Integer range) {
        if (value == null || range == null) {
            return null;
        }
        return value - range + new BigDecimal(Math.random() * range * 2).intValue();
    }

    public static boolean randomChange(BigDecimal chance) {
        if (chance == null) {
            return false;
        }
        if (chance.compareTo(BigDecimal.ONE) >= 0) {
            return true;
        } else if (chance.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        } else {
            return chance.compareTo(new BigDecimal(Math.random())) > 0;
        }
    }

    public static boolean randomChange(double chance) {
        if (chance >= 1) {
            return true;
        } else if (chance <= 0) {
            return false;
        } else {
            return chance > Math.random();
        }
    }
}
