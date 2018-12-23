package com.memoryaxis.nirvana.base.critical;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.effect.Effect;

/**
 * @author memoryaxis@gmail.com
 */
public interface Critical {

    Effect critical(People attackP, People defendP);
}
