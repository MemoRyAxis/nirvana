package com.memoryaxis.nirvana.base;

import com.google.common.collect.Maps;
import com.memoryaxis.nirvana.base.position.Position;
import lombok.Data;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
@Data
public class Team {

    private String name;

    private Map<Position, People> peopleMaps;

    private LinkedList<Position> positionList;

    public Team(String name, People... peoples) {
        if (peoples == null || peoples.length < 1) {
            throw new IllegalStateException();
        }
        this.name = name;
        peopleMaps = Maps.newEnumMap(Position.class);
        this.positionList = new LinkedList<>();
        for (int i = 0; i < Position.getPositions().size() && i < peoples.length; i++) {
            Position position = Position.getPositions().get(i);
            People people = peoples[i];
            if (people != null) {
                this.positionList.add(position);
                this.peopleMaps.put(position, people);
            }
        }
    }

    public void doAttack(Team defendTeam, Position attackPosition) {
        if (positionList.contains(attackPosition)) {
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

            People attackPeople = peopleMaps.get(attackPosition);
            People defendPeople = defendTeam.getPeopleMaps().get(defendPosition);
//            System.out.println(defendPeople);
            attackPeople.doAction(defendPeople);
//            System.out.println(defendPeople);

//            System.out.println();

            if (PeopleUtils.isDead(defendPeople)) {
                defendTeam.getPositionList().remove(defendPosition);
//                System.out.println(defendTeam.getName() + "[" + defendPosition + "] is dead!");
            }
        }
    }
}
