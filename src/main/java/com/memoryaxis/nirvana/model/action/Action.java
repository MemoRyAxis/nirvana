package com.memoryaxis.nirvana.model.action;

import com.memoryaxis.nirvana.model.base.Team;

/**
 * Created by mz on 12/26/2016.
 */
public interface Action {

    void action(Team a, Team b) throws Exception;

}
