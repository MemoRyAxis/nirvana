package com.memoryaxis.nirvana.base.position;

/**
 * @author memoryaxis@gmail.com
 */
public interface Row extends Order {

    enum Rows implements Row {
        FRONT {
            @Override
            public int getOrder() {
                return 1;
            }
        },
        BACK {
            @Override
            public int getOrder() {
                return 2;
            }
        };
    }
}
