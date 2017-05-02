package com.memoryaxis.nirvana.tail;

/**
 * @author memoryaxis@gmail.com
 */
public class Node {

    private int value;

    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * 正常递归
     */
    public int getLength(Node head) {
        if (head == null) return 0;
        return getLength(head.getNext()) + 1;
    }

    /**
     * 使用尾递归
     */
    public int getLength(Node head, int len) {
        if (head == null) return len;
        return getLength(head.getNext(), len);
    }

    // ---

    /**
     * 正常递归
     */
    public static int factorialRecursively(int n) {
        if (n == 0) return 1;
        return factorialRecursively(n - 1) * n;
    }

    /**
     * 使用尾递归
     */
    public static int factorialRecursively(int n, int sum) {
        if (n == 0) return sum;
        return factorialRecursively(n - 1, n * sum);
    }

    /**
     * Continuation
     */
    public static int factorialRecursivelyContinuation(int n) {
        return continuation(n, (n1, sum1) -> n1 * sum1);
    }

    private static int continuation(int n, FactorialContinuation factorialContinuation) {
        if (n == 0) return 1;
        return factorialContinuation.calc(n, continuation(n - 1, factorialContinuation));
    }

    // ---

    public static int fibonacciRecursively(int n) {
        if (n < 2) return n;
        return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
    }

    public static int fibonacciRecursively(int n, int a1, int a2) {
        if (n == 0) return a1;
        return fibonacciRecursively(n - 1, a2, a1 + a2);
    }

    public static int fibonacciRecursivelyContinuation(int n) {
        return continuation(n, (n1, a1, a2) -> a1 + a2);
    }

    private static int continuation(int n, FibonacciContinuation fibonacciContinuation) {
        if (n < 2) return n;
        return fibonacciContinuation.calc(n,
                continuation(n - 1, fibonacciContinuation),
                continuation(n - 2, fibonacciContinuation));
    }

    // ---

    public static void main(String[] args) {
        int a = 20;

        long time1 = System.currentTimeMillis();
        System.out.println(factorialRecursively(a));
        long time2 = System.currentTimeMillis();
        System.out.println(factorialRecursively(a, 1));
        long time3 = System.currentTimeMillis();
        System.out.println(factorialRecursivelyContinuation(a));
        long time4 = System.currentTimeMillis();

        System.out.println(time2 - time1);
        System.out.println(time3 - time2);
        System.out.println(time4 - time3);

        System.out.println();
        System.out.println(fibonacciRecursively(a));
        System.out.println(fibonacciRecursively(a, 0, 1));
        System.out.println(fibonacciRecursivelyContinuation(a));
    }

}
