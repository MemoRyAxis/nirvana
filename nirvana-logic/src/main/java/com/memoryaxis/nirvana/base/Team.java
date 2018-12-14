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

    private Map<Position, People> peopleMaps;

    private LinkedList<Position> positionList;

    public Team(People... peoples) {
        if (peoples == null || peoples.length < 1) {
            throw new IllegalStateException();
        }
        peopleMaps = Maps.newEnumMap(Position.class);
        this.positionList = new LinkedList<>();
        for (int i = 0; i < Position.getPositions().size(); i++) {
            Position position = Position.getPositions().get(i);
            People people = peoples[i];
            this.positionList.add(position);
            this.peopleMaps.put(position, people);
        }
    }
}
