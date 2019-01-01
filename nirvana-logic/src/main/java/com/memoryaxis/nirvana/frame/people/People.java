package com.memoryaxis.nirvana.frame.people;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.base.action.Action;
import com.memoryaxis.nirvana.base.action.Attack;
import com.memoryaxis.nirvana.base.critical.PeopleCritical;
import com.memoryaxis.nirvana.base.effect.Effect;
import com.memoryaxis.nirvana.base.position.ActionTarget;
import com.memoryaxis.nirvana.base.position.Position;
import com.memoryaxis.nirvana.base.position.TargetPosition;
import com.memoryaxis.nirvana.base.reflection.AttackReflection;
import com.memoryaxis.nirvana.base.reflection.CriticalReflection;
import com.memoryaxis.nirvana.base.reflection.PeopleReflection;
import com.memoryaxis.nirvana.base.reflection.SkillReflection;
import com.memoryaxis.nirvana.frame.LOG;
import com.memoryaxis.nirvana.frame.team.Team;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@Builder
public class People {

    // hp start
    @Builder.Default
    private Integer baseHp = 0;

    @Builder.Default
    private Integer currentHp = 0;

    // atk start
    @Builder.Default
    private Integer atk = 0;

    // mp start
    @Builder.Default
    private Integer defaultMp = 0;

    @Builder.Default
    private Integer currentMp = 0;

    @Builder.Default
    private Integer mpRecovery = 40;

    // getTargetPosition start
    @Builder.Default
    private Action action = Attack.Impl.BASE_ATTACK;

    @Builder.Default
    private ActionTarget actionTarget = ActionTarget.Impl.OPPOSITE_DEFAULT;

    private Action skill;

    private ActionTarget skillTarget;

    // critical start
    @Builder.Default
    private Double criticalChance = 0D;

    @Builder.Default
    private Double criticalDmg = 1.5D;

    // life steal start
    @Builder.Default
    private Double lifeSteal = 0D;

    // multiple attack dmg
    @Builder.Default
    private Double multipleAtkDmg = 1D;

    @Builder.Default
    private Double recoveryEffect = 1D;

    // reflection start
    @Builder.Default
    private List<PeopleReflection> peopleReflectionList =
            Lists.newArrayList(PeopleReflection.Impl.BASE);

    @Builder.Default
    private List<AttackReflection> attackReflectionList =
            Lists.newArrayList(AttackReflection.Impl.BASE);

    @Builder.Default
    private List<CriticalReflection> criticalReflectionList =
            Lists.newArrayList(CriticalReflection.Impl.BASE);

    @Builder.Default
    private List<SkillReflection> skillReflectionList =
            Lists.newArrayList(SkillReflection.Impl.BASE);

    /**
     * 增加血量
     */
    public void increaseHp(Integer hp, People from) {
        this.peopleReflectionList.forEach(reflection -> reflection.beforeIncreaseHp(this, hp, from));

        Integer afterHp = this.getCurrentHp() + hp;
        this.setCurrentHp(afterHp > this.getBaseHp() ? this.getBaseHp() : afterHp);

        this.peopleReflectionList.forEach(reflection -> reflection.afterIncreaseHp(this, hp, from));
    }

    /**
     * 减少血量
     */
    public void decreaseHp(Integer hp, People from) {
        this.peopleReflectionList.forEach(reflection -> reflection.beforeDecreaseHp(this, hp, from));

        this.setCurrentHp(this.getCurrentHp() - hp);

        this.peopleReflectionList.forEach(reflection -> reflection.afterDecreaseHp(this, hp, from));
    }

    // fixme before
    // fixme after
    public void doAction(Team attackTeam, Team defendTeam, Position currentPosition) {
        TargetPosition targetPosition;
        if (PeopleUtils.haveSkill(this)) {
            targetPosition = this.skillTarget.getTargetPosition(attackTeam, defendTeam, currentPosition);
        } else {
            targetPosition = this.actionTarget.getTargetPosition(attackTeam, defendTeam, currentPosition);
        }

        List<Position> teammatePositionList = targetPosition.getTeamPositionList();
        for (Position position : teammatePositionList) {
            this.doAction(attackTeam.getPeopleMaps().get(position), currentPosition, position);
        }

        List<Position> oppositePositionList = targetPosition.getOppositePositionList();
        for (Position position : oppositePositionList) {
            People targetPeople = defendTeam.getPeopleMaps().get(position);
            this.doAction(targetPeople, currentPosition, position);
            if (PeopleUtils.isDead(targetPeople)) {
                defendTeam.getPositionList().remove(position);
            }
        }
    }

    public void doAction(People defendP, Position currentPosition, Position targetPosition) {
        int oriHp = defendP.getCurrentHp();
        if (PeopleUtils.haveSkill(this)) {
            this.skillReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));
            Effect effect;
            if (PeopleUtils.haveSkillCritical(this)) {
                this.criticalReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));
                PeopleCritical critical = (PeopleCritical) this.getSkill();
                effect = critical.critical(this, defendP);
                LOG.debug("[" + currentPosition + "->" + targetPosition + "] critical skill: " + critical);
                this.criticalReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
            } else {
                Action action = this.getSkill();
                LOG.debug("[" + currentPosition + "->" + targetPosition + "] skill: " + action);
                effect = action.action(this, defendP);
            }
            this.skillReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
        } else {
            Effect effect;
            this.attackReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));
            if (PeopleUtils.haveActionCritical(this)) {
                this.criticalReflectionList.forEach(reflection -> reflection.beforeAction(this, defendP));
                PeopleCritical critical = (PeopleCritical) this.getAction();
                effect = critical.critical(this, defendP);
                LOG.debug("[" + currentPosition + "->" + targetPosition + "] critical getTargetPosition: " + critical);
                this.criticalReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
            } else {
                Action action = this.getAction();
                effect = action.action(this, defendP);
                LOG.debug("[" + currentPosition + "->" + targetPosition + "] getTargetPosition: " + action);
            }
            this.attackReflectionList.forEach(reflection -> reflection.afterAction(this, defendP, effect));
        }
        LOG.debug("[" + currentPosition + "->" + targetPosition + "] decrease HP: " + (oriHp - defendP.getCurrentHp()));
    }
}
