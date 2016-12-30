package com.memoryaxis.nirvana.model.reflection.gain;

import com.memoryaxis.nirvana.model.base.People;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memoryaxis@gmail.com
 * @todo double?
 */
public class DoubleApGain extends Gain {

    private static final Logger log = LoggerFactory.getLogger(DoubleApGain.class);

    @Override
    public void reflection(People p) {
//        People p = bout.getCurrentPeople();

        p.setAp(p.getAp() + 100);
        log.debug("人员[{}]额外回复{}点怒气", p.getName(), 100);
    }
}
