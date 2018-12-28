package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface ActionReflection {

    void beforeAction(People attackP, People defendP);

    void afterAction(People attackP, People defendP, Effect effect);
}
