package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface Action {

    Effect action(People attackP, People defendP);
}
