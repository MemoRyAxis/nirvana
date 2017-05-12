package com.memoryaxis.nirvana.model;

import com.memoryaxis.nirvana.base.model.People;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author memoryaxis@gmail.com
 */
public class BasePeople implements People {

    private static AtomicLong autoIncreaseId = new AtomicLong(1L);

    private final String name;

    // full health point
    private Integer fhp = 1000;

    // health point
    private Integer hp = 1000;

    private Integer ap = 100;

    public BasePeople() {
        this.name = "people" + autoIncreaseId.getAndIncrement();
    }

    public BasePeople(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getFhp() {
        return fhp;
    }

    public void setFhp(Integer fhp) {
        this.fhp = fhp;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    // other method
    public boolean isDead() {
        return !isAlive();
    }

    public boolean isAlive() {
        return this.getHp() > 0;
    }
}
