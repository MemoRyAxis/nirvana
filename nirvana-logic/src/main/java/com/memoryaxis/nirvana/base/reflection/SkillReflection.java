package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface SkillReflection extends ActionReflection {

    default void beforeAction(People attackP, People defendP) {

    }

    default void afterAction(People attackP, People defendP, Effect effect) {
        attackP.setCurrentMp(attackP.getDefaultMp());
    }
}
