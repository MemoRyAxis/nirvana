package com.memoryaxis.nirvana.model.base;

import com.memoryaxis.nirvana.model.base.position.Position;

import java.util.Map;

/**
 * Created by mz on 12/24/2016.
 */
public class Team {

    private Position currentActionPosition = Position.R1_LEFT;

    private Map<Position, People> peoples;

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

}
