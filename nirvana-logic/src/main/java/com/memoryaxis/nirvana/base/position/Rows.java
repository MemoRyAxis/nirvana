package com.memoryaxis.nirvana.base.position;

/**
 * @author memoryaxis@gmail.com
 */
public enum Rows implements Distance, Order {
    FRONT {
        @Override
        public int getDistance(Distance distance) {
            return 0;
        }

        @Override
        public int getOrder() {
            return 0;
        }
    },
    BACK {
        @Override
        public int getDistance(Distance distance) {
            return Cols.values().length;
        }

        @Override
        public int getOrder() {
            return Cols.values().length;
        }
    };

    public static int getCount() {
        return values().length;
    }
}
