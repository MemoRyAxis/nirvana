package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.frame.team.Team;

/**
 * @author memoryaxis@gmail.com
 */
public interface TeamAction {

    void action(Team attackTeam, Team defendTeam, Position currentPosition);
}
