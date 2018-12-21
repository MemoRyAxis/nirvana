package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface SkillReflection extends ActionReflection {

    void beforeAction(People attackP, People defendP);

    void afterAction(People attackP, People defendP, Effect effect);

    class Default implements SkillReflection {

        @Override
        public void beforeAction(People attackP, People defendP) {
        }

        @Override
        public void afterAction(People attackP, People defendP, Effect effect) {
            attackP.setCurrentMp(attackP.getDefaultMp());
        }
    }

    enum Impl implements SkillReflection {
        BASE(new Default());

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
        }
    }
}

