package com.memoryaxis.nirvana.model.base.rebuild;

import com.memoryaxis.nirvana.model.action.Action;
import com.memoryaxis.nirvana.model.logic.Context;

/**
 * @author memoryaxis@gmail.com
 */
public class BasePeople extends PeopleBasic {

    private Context getContext() {
        return Context.getInstance();
    }


    // people lifecycle
    @Override
    public boolean isLiving() {
        return this.getHealthPoint() > 0;
    }


    // action
    @Override
    public void baseAction() {
        try {
            for (Action action : this.getBaseActions()) {
                action.action(getContext().getAttackTeam(), getContext().getDefenseTeam());
            }
        } catch (Exception e) {
            // TODO: 3/15/2017
            e.printStackTrace();
        }
    }

    @Override
    public void superAction() {
        try {
            for (Action action : this.getSuperActions()) {
                action.action(getContext().getAttackTeam(), getContext().getDefenseTeam());
            }
        } catch (Exception e) {
            // TODO: 3/15/2017
            e.printStackTrace();
        }
    }


    // operation
    @Override
    public Integer increaseHp(Integer value) {
        Integer beforeHp = this.getHealthPoint();
        Integer afterHp = this.getHealthPoint() + value;
        this.setHealthPoint(Integer.min(afterHp, this.getFullHealthPoint()));

        onHpIncrease();

        return afterHp - beforeHp;
    }

    @Override
    public Integer decreaseHp(Integer value) {
        Integer beforeHp = this.getHealthPoint();
        Integer afterHp = this.getHealthPoint() - value;
        this.setHealthPoint(Integer.max(afterHp, 0));

        if (isLiving()) {
            onHpDecrease();
        }

        return afterHp - beforeHp;
    }

    @Override
    public Integer increaseAp(Integer value) {
        Integer beforeAp = this.getAttackPoint();
        Integer afterAp = this.getAttackPoint() + value;
        this.setAttackPoint(afterAp);

        onApIncrease();

        return afterAp - beforeAp;
    }

    @Override
    public Integer decreaseAp(Integer value) {
        Integer beforeAp = this.getAttackPoint();
        Integer afterAp = this.getAttackPoint() - value;
        this.setAttackPoint(Integer.max(afterAp, 0));

        onApDecrease();

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


    // game lifecycle
    @Override
    public void onBattleReady() {

    }

    @Override
    public void onBattleStart() {

    }

    @Override
    public void onRoundReady() {

    }

    @Override
    public void onRoundStart() {

    }

    @Override
    public void onRoundEnd() {

    }

    @Override
    public void onBoutReady() {

    }

    @Override
    public void onBoutStart() {

    }

    @Override
    public void onBoutEnd() {

    }

}
