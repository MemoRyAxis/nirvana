package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.rebuild.BasePeople;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 */
public class BoutRebuild extends Bout {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoutRebuild.class);

    private BasePeople currentPeople;

    public BoutRebuild(BasePeople currentPeople) {
        this.currentPeople = currentPeople;
    }

    @Override
    public void start() {
        try {
            if (getCurrentPeople().getAp() != null && getCurrentPeople().getAp() > 100) {
                currentPeople.superAction();
            } else {
                currentPeople.baseAction();
            }
        } catch (Exception e) {
            LOGGER.error("Bout Error!", e);
        }
    }
}
