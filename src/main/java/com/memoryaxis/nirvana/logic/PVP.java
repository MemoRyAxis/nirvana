package com.memoryaxis.nirvana.logic;

import com.memoryaxis.nirvana.action.SimpleAttack;
import com.memoryaxis.nirvana.base.action.Action;
import com.memoryaxis.nirvana.model.BasePeople;

/**
 * @author memoryaxis@gmail.com
 */
public class PVP {

    private final BasePeople p1;

    private final BasePeople p2;

    public PVP(BasePeople p1, BasePeople p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start() {
        Action action = new SimpleAttack();
        while (true) {
            action.action(p1, p2);
            if (p2.isDead()) {
                break;
            }
            action.action(p2, p1);
            if (p1.isDead()) {
                break;
            }
        }
    }
}
