package com.memoryaxis.nirvana.model.base.position;

/**
 * Created by mz on 12/26/2016.
 */
public enum Position {

    R1_LEFT(X.LEFT, Y.R1),
    R1_MID(X.MID, Y.R1),
    R1_RIGHT(X.RIGHT, Y.R1),
    R2_LEFT(X.LEFT, Y.R2),
    R2_MID(X.MID, Y.R2),
    R2_RIGHT(X.RIGHT, Y.R2);

    private final X x;

    private final Y y;

    Position(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    // FIXME: 12/26/2016
    public static Position[] getPositionSeq(Position currentPosition) {
        if (currentPosition == null ||
                currentPosition.equals(R1_LEFT)) return values();

        int cursor = 0;
        Position[] seq = new Position[values().length];
        for (Position position : values()) {
            if (position.equals(currentPosition)) {
                seq[cursor++] = position;
            }
        }
        for (Position position : values()) {
            if (position.equals(currentPosition)) {
                return seq;
            }
        }
        return seq;
    }

    public static Position[] getPositionSeq() {
        return values();
    }

}
