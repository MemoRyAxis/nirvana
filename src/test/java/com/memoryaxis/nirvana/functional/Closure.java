package com.memoryaxis.nirvana.functional;

/**
 * @author memoryaxis@gmail.com
 */
public class Closure {

    private static CalcFunctionalInterface getAddCalc() {
        return (a1, b1) -> a1 + b1;
    }

    public static void main(String[] args) {
        System.out.println(getAddCalc().calc(1, 2));
    }
}
