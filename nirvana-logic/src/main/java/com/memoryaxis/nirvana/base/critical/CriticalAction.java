package com.memoryaxis.nirvana.base.critical;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface CriticalAction {

    Effect criticalAction(People attackP, People defendP);
}
