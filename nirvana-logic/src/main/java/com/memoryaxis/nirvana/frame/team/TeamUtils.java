package com.memoryaxis.nirvana.frame.team;

import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class TeamUtils {

    public static boolean haveNoPeople(Team team) {
        return team.getPositionList().isEmpty();
    }
}
