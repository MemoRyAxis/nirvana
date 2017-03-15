package com.memoryaxis.nirvana.model.base.rebuild;

import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.position.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author memoryaxis@gmail.com
 */
public class TeamRebuild extends Team {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamRebuild.class);

    public TeamRebuild(String name) {
        super(name);
    }

    private Map<Position, BasePeople> peopleMap = new HashMap<>();

    public Map<Position, BasePeople> getPeopleMap() {
        return peopleMap;
    }

    public void setPeopleMap(Map<Position, BasePeople> peopleMap) {
        this.peopleMap = peopleMap;
    }

    public boolean isOver() {
        return peopleMap.isEmpty();
    }


    public void printInfo() {
        LOGGER.info("Team {} Info: ", this.getName());
        for (Position position : Position.getPositionSeq()) {
            if (this.getPeopleMap().containsKey(position)) {
                BasePeople people = this.getPeopleMap().get(position);
                LOGGER.info("\t{}({}): {}", people, position, people.getHealthPoint());
            }
        }
    }

}
