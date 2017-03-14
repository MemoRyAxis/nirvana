package com.memoryaxis.nirvana.model.base.position;

/**
 * @author memoryaxis@gmail.com
 */
public enum Position {

    R1_LEFT(X.LEFT, Y.R1, "1L") {
        @Override
        public Position getNext() {
            return R1_MID;
        }
    },
    R1_MID(X.MID, Y.R1, "1M") {
        @Override
        public Position getNext() {
            return R1_RIGHT;
        }
    },
    R1_RIGHT(X.RIGHT, Y.R1, "1R") {
        @Override
        public Position getNext() {
            return R2_LEFT;
        }
    },
    R2_LEFT(X.LEFT, Y.R2, "2L") {
        @Override
        public Position getNext() {
            return R2_MID;
        }
    },
    R2_MID(X.MID, Y.R2, "2M") {
        @Override
        public Position getNext() {
            return R2_RIGHT;
        }
    },
    R2_RIGHT(X.RIGHT, Y.R2, "2R") {
        @Override
        public Position getNext() {
            return R1_LEFT;
        }
    };

    private final X x;

    private final Y y;

    private final String name;

    Position(X x, Y y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public static Position[] getPositionSeq() {
        return values();
    }

    public Position getNext() {
        return R1_LEFT;
    }

}
