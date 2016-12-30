package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.base.position.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mz on 12/24/2016.
 */
public class Team {

    private static final Logger log = LoggerFactory.getLogger(Team.class);

    private final String name;

    private Position currentActionPosition = Position.R1_LEFT;

    private Map<Position, People> peoples = new HashMap<>();

    public Team(String name) {
        this.name = name;
    }

    public Position getCurrentActionPosition() {
        return currentActionPosition;
    }

    public void setCurrentActionPosition(Position currentActionPosition) {
        this.currentActionPosition = currentActionPosition;
    }

    public Map<Position, People> getPeoples() {
        return peoples;
    }

    public void setPeoples(Map<Position, People> peoples) {
        this.peoples = peoples;
    }

    // ---

    public boolean isOver() {
        return peoples.isEmpty();
    }

    public void printInfo() {
        log.info("Team {} Info: ", this.name);
        for (Position position : Position.getPositionSeq()) {
            if (this.getPeoples().containsKey(position)) {
                People people = this.getPeoples().get(position);
                log.info("\t{}({}): {}", people.getName(), position, people.getHp());
            }
        }
    }

}
