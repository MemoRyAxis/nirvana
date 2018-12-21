package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

import java.math.BigDecimal;

/**
 * @author memoryaxis@gmail.com
 */
public interface AttackReflection extends ActionReflection {

    void beforeAction(People attackP, People defendP);

    void afterAction(People attackP, People defendP, Effect effect);

    class Default implements AttackReflection {

        @Override
        public void beforeAction(People attackP, People defendP) {
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
            attackP.setCurrentMp(attackP.getCurrentMp() + attackP.getMpRecovery());
        }
    }

    enum Impl implements AttackReflection {
        BASE(new Default()),
        LIFE_STEAL(new Default() {
            @Override
            public void afterAction(People attackP, People defendP, Effect effect) {
                super.afterAction(attackP, defendP, effect);
                Integer stealHp = new BigDecimal(effect.getDecreaseHp() * 0.3).intValue();
                attackP.increaseHp(stealHp, defendP);
            }
        });

        private AttackReflection reflection;

        Impl(AttackReflection reflection) {
            this.reflection = reflection;
        }

        @Override
        public void beforeAction(People attackP, People defendP) {
            reflection.beforeAction(attackP, defendP);
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
            reflection.afterAction(attackP, defendP, effect);
        }
    }
}

