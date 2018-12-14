package com.memoryaxis.nirvana.base;

import com.memoryaxis.nirvana.base.position.Position;
import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class TeamUtils {

    public static void printTeam(Team team) {
        log.info("{}: {}, {}: {}, {}: {}",
                "FL", team.getPeopleMaps().get(Position.FRONT_LEFT).getCurrentHp(),
                "FM", team.getPeopleMaps().get(Position.FRONT_MIDDLE).getCurrentHp(),
                "FR", team.getPeopleMaps().get(Position.FRONT_RIGHT).getCurrentHp());
        log.info("{}: {}, {}: {}, {}: {}",
                "BL", team.getPeopleMaps().get(Position.BACK_LEFT).getCurrentHp(),
                "BM", team.getPeopleMaps().get(Position.BACK_MIDDLE).getCurrentHp(),
                "BR", team.getPeopleMaps().get(Position.BACK_RIGHT).getCurrentHp());
    }
}
