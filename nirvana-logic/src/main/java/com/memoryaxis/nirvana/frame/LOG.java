package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.frame.people.PeopleUtils;
import com.memoryaxis.nirvana.frame.team.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class LOG {

    private static final Logger teamLog = LoggerFactory.getLogger("TEAM");

    private static final Logger peopleLog = LoggerFactory.getLogger("PEOPLE");

    private static final Logger logicLog = LoggerFactory.getLogger("LOGIC");

    public static final char DEFEND_CHAR = '↓';

    public static final char ATTACK_CHAR = '↑';

    public static void roundStart(int roundCount) {
        logicLog.info("--- round {} start ---", roundCount);
    }

    public static void roundEnd(int roundCount) {
        logicLog.info("--- round {} end ---", roundCount);
        logicLog.info("");
    }

    public static void teamGameEnd(Team attackTeam, Team defendTeam, int roundCount) {
        logicLog.info("");
        logicLog.info("--- round over ({}) ---", roundCount);
        teamState(defendTeam, false);
        teamState(attackTeam, true);
        logicLog.info("");
        if (attackTeam.getPositionList().size() > defendTeam.getPositionList().size()) {
            logicLog.info("attack team [{}] win!", attackTeam.getName());
        } else {
            logicLog.info("defend team [{}] win!", defendTeam.getName());
        }
    }

    public static void teamsName(Team attackTeam, Team defendTeam) {
        logicLog.info("Attack Team: {}, Defend Team: {}", attackTeam.getName(), defendTeam.getName());
    }

    public static void teamState(Team team, boolean isAttack) {
        if (isAttack) {
            teamLog.info("{}", ATTACK_CHAR);
            teamLog.info("{}: {}, {}: {}, {}: {}",
                    "FL", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_LEFT)),
                    "FM", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_MIDDLE)),
                    "FR", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_RIGHT)));
            teamLog.info("{}: {}, {}: {}, {}: {}",
                    "BL", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_LEFT)),
                    "BM", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_MIDDLE)),
                    "BR", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_RIGHT)));
            teamLog.info("{} Attack Team: {}", ATTACK_CHAR, team.getName());
        } else {
            teamLog.info("{} Defend Team: {}", DEFEND_CHAR, team.getName());
            teamLog.info("{}: {}, {}: {}, {}: {}",
                    "BR", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_RIGHT)),
                    "BM", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_MIDDLE)),
                    "BL", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.BACK_LEFT)));
            teamLog.info("{}: {}, {}: {}, {}: {}",
                    "FR", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_RIGHT)),
                    "FM", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_MIDDLE)),
                    "FL", PeopleUtils.getPeopleInfo(team.getPeopleMaps().get(Position.FRONT_LEFT)));
            teamLog.info("{}", DEFEND_CHAR);
        }
    }

    public static void debug(String msg) {
        logicLog.debug("\t\t\t\t {}", msg);
    }
}
