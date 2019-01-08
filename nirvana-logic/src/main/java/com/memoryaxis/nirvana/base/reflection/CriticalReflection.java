package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface CriticalReflection extends ActionReflection {

    class Default implements CriticalReflection {

        @Override
        public void beforeAction(People attackP, People defendP) {
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
        }
    }

    enum Impl implements CriticalReflection {
        BASE(new Default());

        private CriticalReflection reflection;

        Impl(CriticalReflection reflection) {
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
