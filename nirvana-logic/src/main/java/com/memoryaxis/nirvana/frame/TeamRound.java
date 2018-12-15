package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@AllArgsConstructor
public class TeamRound {

    private Team attackTeam;

    private Team defendTeam;
}
