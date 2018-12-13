package com.memoryaxis.nirvana.base.position;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
public enum Position {

    FRONT_LEFT(Row.Rows.FRONT, Col.Cols.LEFT),

    FRONT_MIDDLE(Row.Rows.FRONT, Col.Cols.MIDDLE),

    FRONT_RIGHT(Row.Rows.FRONT, Col.Cols.RIGHT),

    BACK_LEFT(Row.Rows.BACK, Col.Cols.LEFT),

    BACK_MIDDLE(Row.Rows.BACK, Col.Cols.MIDDLE),

    BACK_RIGHT(Row.Rows.BACK, Col.Cols.RIGHT);

    private Row row;

    private Col col;

    Position(Row row, Col col) {
        this.row = row;
        this.col = col;
    }

    public Row getRow() {
        return row;
    }

    public Col getCol() {
        return col;
    }

    public static List<Position> getPositions() {
        return Lists.newArrayList(values());
    }
}
