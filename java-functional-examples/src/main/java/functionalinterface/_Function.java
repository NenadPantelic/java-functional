package functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        int value = incrementByOne(0);
        System.out.println("Increment with regular function: " + value);

        Integer value2 = incrementByOneFunction.apply(0);
        System.out.println("Increment with Function: " + value2);

    }

    // Function - function that accepts only one argument and returns a result
    // accepts Integer - first generic value
    // returns Integer - second generic value
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // regular function
    static int incrementByOne(int number) {
        return number + 1;
    }

}
