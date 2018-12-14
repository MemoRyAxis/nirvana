package com.memoryaxis.nirvana.frame;

import com.google.common.collect.Ordering;
import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.base.PeopleUtils;
import com.memoryaxis.nirvana.base.Team;
import com.memoryaxis.nirvana.base.TeamUtils;
import com.memoryaxis.nirvana.base.position.Distance;
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

        System.out.println("attack team");
        TeamUtils.printTeam(attackTeam);
        System.out.println("defend team");
        TeamUtils.printTeam(defendTeam);

        while (currentRoundCount <= MAX_ROUND_COUNT) {

            for (int i = 0; i < Position.getPositions().size(); i++) {
                Position attackPosition = Position.getPositions().get(i);
                doAttack(attackTeam, defendTeam, attackPosition);
                if (defendTeam.getPositionList().isEmpty()) {
                    log.info("defend team lose");
                }

                doAttack(defendTeam, attackTeam, attackPosition);
                if (attackTeam.getPositionList().isEmpty()) {
                    log.info("attack team lose");
                }
            }

            System.out.println("--- round " + currentRoundCount + " ---");
            System.out.println("attack team");
            TeamUtils.printTeam(attackTeam);
            System.out.println("defend team");
            TeamUtils.printTeam(defendTeam);

            currentRoundCount++;
        }
    }

    private static void doAttack(Team attackTeam, Team defendTeam, Position attackPosition) {
        Ordering<Distance> distanceOrdering = Ordering.natural()
                .onResultOf(attackPosition::getDistance);

        if (attackTeam.getPositionList().contains(attackPosition)) {
            Position defendPosition = defendTeam.getPositionList().stream()
                    .min(distanceOrdering)
                    .orElseThrow(IllegalStateException::new);

            People attackPeople = attackTeam.getPeopleMaps().get(attackPosition);
            People defendPeople = defendTeam.getPeopleMaps().get(defendPosition);
            attackPeople.attack(defendPeople);

            if (PeopleUtils.isDead(defendPeople)) {
                defendTeam.getPositionList().remove(defendPosition);
            }
        }
    }
}
