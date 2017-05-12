package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.logic.PVP;
import com.memoryaxis.nirvana.model.BasePeople;

/**
 * @author memoryaxis@gmail.com
 */
public class Main {

    private static void pvp() {
        BasePeople p1 = new BasePeople();
        BasePeople p2 = new BasePeople();

        PVP pvp = new PVP(p1, p2);

        pvp.start();
    }

    public static void main(String[] args) {
        pvp();
    }
}
