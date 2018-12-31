package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.frame.people.People;

/**
 * @author memoryaxis@gmail.com
 */
public interface PeopleAction {

    Effect action(People attackP, People defendP);
}
