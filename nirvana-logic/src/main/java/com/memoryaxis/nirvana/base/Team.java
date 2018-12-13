package com.memoryaxis.nirvana.base;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.memoryaxis.nirvana.base.position.Col;
import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.base.position.Row;
import lombok.Data;

import java.util.LinkedList;

/**
 * @author memoryaxis@gmail.com
 */
@Data
public class Team {

    private Table<Row, Col, People> teammate;

    private People currentPeople;

    private Position currentPosition;

    private LinkedList<Position> positionList;

    public Team(People... peoples) {
        if (peoples == null || peoples.length < 1) {
            throw new IllegalStateException();
        }
        this.teammate = HashBasedTable.create(Row.Rows.values().length, Col.Cols.values().length);
        this.positionList = new LinkedList<>();
        for (int i = 0; i < Position.getPositions().size(); i++) {
            Position position = Position.getPositions().get(i);
            People people = peoples[i];
            if (peoples[i] != null) {
                this.currentPosition = position;
                this.currentPeople = peoples[i];
                this.positionList.add(position);
            }
            this.teammate.put(position.getRow(), position.getCol(), people);
        }
        if (currentPosition == null || currentPeople == null) {
            throw new IllegalStateException();
        }
    }
}
