package com.memoryaxis.nirvana.base.action;

import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.frame.people.People;
import com.memoryaxis.nirvana.frame.people.PeopleUtils;
import com.memoryaxis.nirvana.frame.team.Team;

/**
 * @author memoryaxis@gmail.com
 */
public interface TeamAttack extends TeamAction {

    @Override
    default void action(Team attackTeam, Team defendTeam, Position currentPosition) {
        Position defendPosition = null;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < defendTeam.getPositionList().size(); i++) {
            Position dp = defendTeam.getPositionList().get(i);
            int distance = currentPosition.getDistance(dp);
            if (distance < minDistance) {
                minDistance = distance;
                defendPosition = dp;
            }
        }

        People attackPeople = attackTeam.getPeopleMaps().get(currentPosition);
        People defendPeople = defendTeam.getPeopleMaps().get(defendPosition);
        attackPeople.doAction(defendPeople);
        if (PeopleUtils.isDead(defendPeople)) {
            defendTeam.getPositionList().remove(defendPosition);
        }
    }

    enum Impl implements TeamAttack {
        BASE_ATTACK,

        MULTIPLE_ATTACK {
            @Override
            public void action(Team attackTeam, Team defendTeam, Position currentPosition) {
                for (Position defendPosition : defendTeam.getPositionList()) {
                    if (attackTeam.getPositionList().contains(currentPosition)) {
                        attackTeam.getPeopleMaps().get(currentPosition)
                                .doAction(defendTeam.getPeopleMaps().get(defendPosition));
                    }
                }
            }
        }
    }
}
