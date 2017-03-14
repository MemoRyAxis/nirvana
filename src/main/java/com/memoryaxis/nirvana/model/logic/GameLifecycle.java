package com.memoryaxis.nirvana.model.logic;

/**
 * @author memoryaxis@gmail.com
 */
public interface GameLifecycle {

//    boolean isStarted();

    void onBattleReady();

    void onBattleStart();

    void onRoundReady();

    void onRoundStart();

    void onRoundEnd();

    void onBoutReady();

    void onBoutStart();

    void onBoutEnd();

}
