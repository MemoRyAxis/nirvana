package com.memoryaxis.nirvana.base.position;

/**
 * @author memoryaxis@gmail.com
 */
public enum Cols implements Distance, Order {
    LEFT {
        @Override
        public int getOrder() {
            return 0;
        }

        @Override
        public int getDistance(Distance distance) {
            if (distance == null) {
                throw new IllegalStateException();
            }
            Cols defendCol = (Cols) distance;
            switch (defendCol) {
                case LEFT:
                    return 3;
                case MIDDLE:
                    return 2;
                case RIGHT:
                    return 1;
            }
            return Integer.MAX_VALUE;
        }
    },
    MIDDLE {
        @Override
        public int getOrder() {
            return 1;
        }

        @Override
        public int getDistance(Distance distance) {
            if (distance == null) {
                throw new IllegalStateException();
            }
            Cols defendCol = (Cols) distance;
            switch (defendCol) {
                case LEFT:
                    return 3;
                case MIDDLE:
                    return 1;
                case RIGHT:
                    return 2;
            }
            return Integer.MAX_VALUE;
        }
    },
    RIGHT {
        @Override
        public int getOrder() {
            return 2;
        }

        @Override
        public int getDistance(Distance distance) {
            if (distance == null) {
                throw new IllegalStateException();
            }
            Cols defendCol = (Cols) distance;
            switch (defendCol) {
                case LEFT:
                    return 1;
                case MIDDLE:
                    return 2;
                case RIGHT:
                    return 3;
            }
            return Integer.MAX_VALUE;
        }
    };

    public static int getCount() {
        return values().length;
    }
}
