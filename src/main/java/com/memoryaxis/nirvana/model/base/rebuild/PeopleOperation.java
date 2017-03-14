package com.memoryaxis.nirvana.model.base.rebuild;

/**
 * 人物基本属性的变更
 *
 * @author memoryaxis@gmail.com
 */
public interface PeopleOperation {

    Integer increaseHp(Integer value);

    Integer decreaseHp(Integer value);

    Integer increaseAp(Integer value);

    Integer decreaseAp(Integer value);

}
