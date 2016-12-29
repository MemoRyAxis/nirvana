package com.memoryaxis.nirvana.model.base.position;

/**
 * Created by mz on 12/26/2016.
 */
public enum Position {

    R1_LEFT(X.LEFT, Y.R1) {
        @Override
        public Position getNext() {
            return R1_MID;
        }
    },
    R1_MID(X.MID, Y.R1) {
        @Override
        public Position getNext() {
            return R1_RIGHT;
        }
    },
    R1_RIGHT(X.RIGHT, Y.R1) {
        @Override
        public Position getNext() {
            return R2_LEFT;
        }
    },
    R2_LEFT(X.LEFT, Y.R2) {
        @Override
        public Position getNext() {
            return R2_MID;
        }
    },
    R2_MID(X.MID, Y.R2) {
        @Override
        public Position getNext() {
            return R2_RIGHT;
        }
    },
    R2_RIGHT(X.RIGHT, Y.R2) {
        @Override
        public Position getNext() {
            return R1_LEFT;
        }
    };

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

    public static Position[] getPositionSeq() {
        return values();
    }

    public Position getNext() {
        return R1_LEFT;
    }

}
