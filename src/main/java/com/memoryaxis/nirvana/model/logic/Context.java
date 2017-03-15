package com.memoryaxis.nirvana.model.logic;

import com.memoryaxis.nirvana.model.base.Team;
import com.memoryaxis.nirvana.model.base.rebuild.BasePeople;

/**
 * @author memoryaxis@gmail.com
 */
public class Context {

    private static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private Context() {
    }

    private Team attackTeam;

    private Team defenseTeam;

    private BasePeople currentPeople;

    public Team getAttackTeam() {
        return attackTeam;
    }

    public void setAttackTeam(Team attackTeam) {
        this.attackTeam = attackTeam;
    }

    public Team getDefenseTeam() {
        return defenseTeam;
    }

    public void setDefenseTeam(Team defenseTeam) {
        this.defenseTeam = defenseTeam;
    }

    public BasePeople getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(BasePeople currentPeople) {
        this.currentPeople = currentPeople;
    }

}
