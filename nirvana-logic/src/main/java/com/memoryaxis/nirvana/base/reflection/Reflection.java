package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface Reflection {

    default void beforeIncreaseHp(People people, Integer hp, People from) {

    }

    default void afterIncreaseHp(People people, Integer hp, People from) {

    }

    default void beforeDecreaseHp(People people, Integer hp, People from) {

    }

    default void afterDecreaseHp(People people, Integer hp, People from) {

    }

    default void afterAction(People people) {

    }

    enum Reflections implements Reflection {
        BASE_REFLECTION,

        REFLECTS {
            @Override
            public void afterDecreaseHp(People people, Integer hp, People from) {
                Integer reflectHp = new BigDecimal(hp * 0.5).intValue();
                from.decreaseHp(reflectHp, people);
            }
        }
    }
}