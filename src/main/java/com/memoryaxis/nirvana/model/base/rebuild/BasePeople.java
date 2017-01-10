package com.memoryaxis.nirvana.model.base.rebuild;

/**
 * @author memoryaxis@gmail.com
 */
public class BasePeople extends PeopleBasic {

    private final String name;

    public BasePeople(String name) {
        this.name = name;
    }

    // lifecycle
    @Override
    public boolean isLiving() {
        return this.getHealthPoint() > 0;
    }

    @Override
    public void ready() {

    }

    @Override
    public void start() {

    }

    @Override
    public void over() {

    }


    // action
//    @Override
//    public void baseAction() {
//
//    }
//
//    @Override
//    public void superAction() {
//
//    }


    // operation
    @Override
    public Integer increaseHp(Integer value) {
        Integer beforeHp = this.getHealthPoint();
        Integer afterHp = this.getHealthPoint() + value;
        this.setHealthPoint(Integer.min(afterHp, this.getFullHealthPoint()));
        return afterHp - beforeHp;
    }

    @Override
    public Integer decreaseHp(Integer value) {
        Integer beforeHp = this.getHealthPoint();
        Integer afterHp = this.getHealthPoint() - value;
        this.setHealthPoint(Integer.max(afterHp, 0));
        return afterHp - beforeHp;
    }

    @Override
    public Integer increaseAp(Integer value) {
        Integer beforeAp = this.getAttackPoint();
        Integer afterAp = this.getAttackPoint() + value;
        this.setAttackPoint(afterAp);
        return afterAp - beforeAp;
    }

    @Override
    public Integer decreaseAp(Integer value) {
        Integer beforeAp = this.getAttackPoint();
        Integer afterAp = this.getAttackPoint() - value;
        this.setAttackPoint(Integer.max(afterAp, 0));
        if (!this.isLiving()) {

        }
        return afterAp - beforeAp;
    }


    // reflection
    @Override
    public void onHpIncrease() {

    }

    @Override
    public void onHpDecrease() {

    }

    @Override
    public void onApIncrease() {

    }

    @Override
    public void onApDecrease() {

    }

}
