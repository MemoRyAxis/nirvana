package com.memoryaxis.nirvana.base.reflection;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface ActionReflection {

    void beforeAction(People attackP, People defendP);

    void afterAction(People attackP, People defendP, Effect effect);
}
