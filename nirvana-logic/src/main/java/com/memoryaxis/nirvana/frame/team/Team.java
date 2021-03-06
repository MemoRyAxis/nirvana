package com.memoryaxis.nirvana.frame.team;

import com.google.common.collect.Maps;
import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.frame.people.People;
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
            peopleMaps.get(attackPosition).doAction(
                    this, defendTeam, attackPosition);
        }
    }
}
