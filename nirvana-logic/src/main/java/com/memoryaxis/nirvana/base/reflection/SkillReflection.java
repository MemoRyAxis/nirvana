package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface SkillReflection extends ActionReflection {

    class Default implements SkillReflection {

        @Override
        public void beforeAction(People attackP, People defendP) {
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
        }
    }

    enum Impl implements SkillReflection {
        BASE(new Default()),
        LIFE_STEAL(new Default() {
            @Override
            public void afterAction(People attackP, People defendP, Effect effect) {
                Integer stealHp = new BigDecimal(effect.getDecreaseHp() * attackP.getLifeSteal()).intValue();
                attackP.increaseHp(stealHp, defendP);
            }
        });

        private SkillReflection reflection;

        Impl(SkillReflection reflection) {
            this.reflection = reflection;
        }

        @Override
        public void beforeAction(People attackP, People defendP) {
            reflection.beforeAction(attackP, defendP);
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
            reflection.afterAction(attackP, defendP, effect);
            attackP.setCurrentMp(attackP.getDefaultMp());
        }
    }
}

