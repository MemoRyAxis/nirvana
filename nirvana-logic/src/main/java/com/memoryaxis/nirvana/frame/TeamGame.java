package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.Team;
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

            for (int i = 0; i < Position.getPositions().size(); i++) {
                Position position = Position.getPositions().get(i);

                if (attackTeam.getPositionList().contains(position)) {

                }

                if (defendTeam.getPositionList().contains(position)) {

                }
            }

            currentRoundCount++;
        }
    }
}
