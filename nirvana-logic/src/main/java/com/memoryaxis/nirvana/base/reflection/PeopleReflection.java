package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface PeopleReflection {

    void beforeIncreaseHp(People people, Integer hp, People from);

    void afterIncreaseHp(People people, Integer hp, People from);

    void beforeDecreaseHp(People people, Integer hp, People from);

    void afterDecreaseHp(People people, Integer hp, People from);

    class Default implements PeopleReflection {

        @Override
        public void beforeIncreaseHp(People people, Integer hp, People from) {
        }

        @Override
        public void afterIncreaseHp(People people, Integer hp, People from) {
        }

        @Override
        public void beforeDecreaseHp(People people, Integer hp, People from) {
        }

        @Override
        public void afterDecreaseHp(People people, Integer hp, People from) {
        }
    }

    enum Impl implements PeopleReflection {

        BASE(new Default()),

        REFLECTS(new Default() {
            @Override
            public void afterDecreaseHp(People people, Integer hp, People from) {
                super.afterDecreaseHp(people, hp, from);
                Integer reflectHp = new BigDecimal(hp * 0.3).intValue();
                from.decreaseHp(reflectHp, people);
            }
        });

        private PeopleReflection reflection;

        Impl(PeopleReflection reflection) {
            this.reflection = reflection;
        }

        @Override
        public void beforeIncreaseHp(People people, Integer hp, People from) {
            reflection.beforeIncreaseHp(people, hp, from);
        }

        @Override
        public void afterIncreaseHp(People people, Integer hp, People from) {
            reflection.afterIncreaseHp(people, hp, from);
        }

        @Override
        public void beforeDecreaseHp(People people, Integer hp, People from) {
            reflection.beforeDecreaseHp(people, hp, from);
        }

        @Override
        public void afterDecreaseHp(People people, Integer hp, People from) {
            reflection.afterDecreaseHp(people, hp, from);
        }
    }
}
