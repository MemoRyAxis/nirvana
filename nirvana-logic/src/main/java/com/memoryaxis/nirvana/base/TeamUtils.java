package com.memoryaxis.nirvana.base;

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
