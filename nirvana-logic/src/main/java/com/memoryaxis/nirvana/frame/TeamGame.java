package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.frame.team.Team;
import com.memoryaxis.nirvana.frame.team.TeamUtils;
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

        LOG.teamsName(attackTeam, defendTeam);

        while (currentRoundCount <= MAX_ROUND_COUNT) {

            LOG.roundStart(currentRoundCount);

            LOG.teamState(attackTeam, true);
            LOG.teamState(defendTeam, false);

            boolean isOneTeamLose = false;

            for (int i = 0; i < Position.getPositions().size(); i++) {
                Position attackPosition = Position.getPositions().get(i);

                attackTeam.doAttack(defendTeam, attackPosition);
                if (TeamUtils.haveNoPeople(defendTeam)) {
                    isOneTeamLose = true;
                    break;
                }

                defendTeam.doAttack(attackTeam, attackPosition);
                if (TeamUtils.haveNoPeople(attackTeam)) {
                    isOneTeamLose = true;
                    break;
                }
            }

            LOG.roundEnd(currentRoundCount);

            currentRoundCount++;

            if (isOneTeamLose) {
                break;
            }
        }

        LOG.teamGameEnd(attackTeam, defendTeam, currentRoundCount - 1);
    }
}
