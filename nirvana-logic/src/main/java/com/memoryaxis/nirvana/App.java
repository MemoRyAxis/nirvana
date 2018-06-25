package com.memoryaxis.nirvana;

import com.memoryaxis.nirvana.base.People;
import com.memoryaxis.nirvana.frame.Game;
import com.memoryaxis.nirvana.frame.Round;

/**
 * @author memoryaxis@gmail.com
 */
public class App {

    public static void main(String[] args) {
        People p1 = new People(100, 100, 21);
        People p2 = new People(130, 130, 18);

        Game.start(new Round(p1, p2));
    }
}
