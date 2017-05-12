package com.memoryaxis.nirvana.action;

import com.memoryaxis.nirvana.base.action.Action;
import com.memoryaxis.nirvana.model.BasePeople;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class SimpleAttack implements Action {

    private static final Logger log = LoggerFactory.getLogger(SimpleAttack.class);

    @Override
    public void action(BasePeople p1, BasePeople p2) {
        Integer oriHp = p2.getHp();
        Integer aftHp = p2.getHp() - p1.getAp();
        p2.setHp(Integer.max(aftHp, 0));
        log.info("{} attack {}, {} lose [{}] health.", p1.getName(), p2.getName(), p2.getName(), oriHp - aftHp);
        if (p2.isDead()) {
            log.info("{} is dead!", p2.getName());
        }
    }
}
