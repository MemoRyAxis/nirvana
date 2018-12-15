package com.memoryaxis.nirvana.base;

import com.memoryaxis.nirvana.base.position.Position;
import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class TeamUtils {

    public static boolean haveNoPeople(Team team) {
        return team.getPositionList().isEmpty();
    }

    public static void printTeam(Team team, boolean isAttack) {
        if (isAttack) {
            log.info("{}: {}, {}: {}, {}: {}",
                    "BR", printPeople(team.getPeopleMaps().get(Position.BACK_RIGHT)),
                    "BM", printPeople(team.getPeopleMaps().get(Position.BACK_MIDDLE)),
                    "BL", printPeople(team.getPeopleMaps().get(Position.BACK_LEFT)));
            log.info("{}: {}, {}: {}, {}: {}",
                    "FR", printPeople(team.getPeopleMaps().get(Position.FRONT_RIGHT)),
                    "FM", printPeople(team.getPeopleMaps().get(Position.FRONT_MIDDLE)),
                    "FL", printPeople(team.getPeopleMaps().get(Position.FRONT_LEFT)));
        } else {
            log.info("{}: {}, {}: {}, {}: {}",
                    "FL", printPeople(team.getPeopleMaps().get(Position.FRONT_LEFT)),
                    "FM", printPeople(team.getPeopleMaps().get(Position.FRONT_MIDDLE)),
                    "FR", printPeople(team.getPeopleMaps().get(Position.FRONT_RIGHT)));
            log.info("{}: {}, {}: {}, {}: {}",
                    "BL", printPeople(team.getPeopleMaps().get(Position.BACK_LEFT)),
                    "BM", printPeople(team.getPeopleMaps().get(Position.BACK_MIDDLE)),
                    "BR", printPeople(team.getPeopleMaps().get(Position.BACK_RIGHT)));
        }
    }

    private static int printPeople(People people) {
        if (PeopleUtils.isDead(people)) {
            return 0;
        }
        return people.getCurrentHp();
    }
}
