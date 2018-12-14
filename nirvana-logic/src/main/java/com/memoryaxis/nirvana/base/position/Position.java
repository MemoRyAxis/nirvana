package com.memoryaxis.nirvana.base.position;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
public enum Position implements Distance {

    FRONT_LEFT(Rows.FRONT, Cols.LEFT),

    FRONT_MIDDLE(Rows.FRONT, Cols.MIDDLE),

    FRONT_RIGHT(Rows.FRONT, Cols.RIGHT),

    BACK_LEFT(Rows.BACK, Cols.LEFT),

    BACK_MIDDLE(Rows.BACK, Cols.MIDDLE),

    BACK_RIGHT(Rows.BACK, Cols.RIGHT);

    private Rows row;

    private Cols col;

    Position(Rows row, Cols col) {
        this.row = row;
        this.col = col;
    }

    public Rows getRow() {
        return row;
    }

    public Cols getCol() {
        return col;
    }

    public static List<Position> getPositions() {
        return Lists.newArrayList(values());
    }

    @Override
    public int getDistance(Distance distance) {
        if (distance instanceof Position) {
            Position position = (Position) distance;
            return this.getRow().getDistance(position.getRow())
                    + this.getCol().getDistance(position.getCol());
        }
        throw new IllegalStateException();
    }
}
