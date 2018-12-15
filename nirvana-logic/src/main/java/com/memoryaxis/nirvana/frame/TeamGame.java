package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.PeopleUtils;
import com.memoryaxis.nirvana.base.Team;
import com.memoryaxis.nirvana.base.TeamUtils;
import com.memoryaxis.nirvana.base.position.Position;
import lombok.extern.slf4j.Slf4j;

/**
 * @author memoryaxis@gmail.com
 */
@Slf4j
public class TeamGame {

    private static final int MAX_ROUND_COUNT = 20;

    public static void start(TeamRound teamRound) {
        int currentRoundCount = 1;

        Team attackTeam = teamRound.getAttackTeam();
        Team defendTeam = teamRound.getDefendTeam();

        while (currentRoundCount <= MAX_ROUND_COUNT) {

            System.out.println("--- round " + currentRoundCount + " start ---");

            System.out.println("attack team");
            TeamUtils.printTeam(attackTeam, true);
            System.out.println("defend team");
            TeamUtils.printTeam(defendTeam, false);

            boolean isOneTeamLose = false;

            for (int i = 0; i < Position.getPositions().size(); i++) {
                Position attackPosition = Position.getPositions().get(i);

                doAttack(attackTeam, defendTeam, attackPosition);
                if (TeamUtils.haveNoPeople(defendTeam)) {
                    log.info("defend team lose");
                    isOneTeamLose = true;
                    break;
                }

                doAttack(defendTeam, attackTeam, attackPosition);
                if (TeamUtils.haveNoPeople(attackTeam)) {
                    log.info("attack team lose");
                    isOneTeamLose = true;
                    break;
                }
            }
            System.out.println("--- round " + currentRoundCount + " end ---");
            System.out.println();

            if (isOneTeamLose) {
                break;
            }

            currentRoundCount++;
        }
    }

    private static void doAttack(Team attackTeam, Team defendTeam, Position attackPosition) {

        if (attackTeam.getPositionList().contains(attackPosition)) {
            Position defendPosition = null;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < defendTeam.getPositionList().size(); i++) {
                Position dp = defendTeam.getPositionList().get(i);
                int distance = attackPosition.getDistance(dp);
                if (distance < minDistance) {
                    minDistance = distance;
                    defendPosition = dp;
                }
            }

//            System.out.println("ap: " + attackPosition + ", dp: " + defendPosition);

            People attackPeople = attackTeam.getPeopleMaps().get(attackPosition);
            People defendPeople = defendTeam.getPeopleMaps().get(defendPosition);
//            System.out.println(defendPeople);
            attackPeople.attack(defendPeople);
//            System.out.println(defendPeople);

//            System.out.println();

            if (PeopleUtils.isDead(defendPeople)) {
                defendTeam.getPositionList().remove(defendPosition);
                defendTeam.getPeopleMaps().remove(defendPosition);
//                System.out.println(defendTeam.getName() + "[" + defendPosition + "] is dead!");
            }
        }
    }
}
