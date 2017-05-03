package com.memoryaxis.nirvana.functional;

/**
 * @author memoryaxis@gmail.com
 */
public class SwitchRebuild {

    static void printLog(int state) throws Exception {
        switch (state) {
            case 1:
                System.out.println("state 1");
                break;
            case 2:
                System.out.println("state 2");
                break;
            default:
                throw new Exception("state error");
        }
    }

    static void printLog(PrintFunctionalInterface printer) {
        printer.print();
    }

    public static void main(String[] args) throws Exception {
        printLog(1);
        printLog(2);
        System.out.println();
        printLog(() -> System.out.println("state 1"));
        printLog(() -> System.out.println("state 2"));
    }

}
