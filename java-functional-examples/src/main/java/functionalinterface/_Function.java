package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        int value = incrementByOne(0);
        System.out.println("Increment with regular function: " + value);

        Integer value2 = incrementByOneFunction.apply(1);
        System.out.println("Increment with Function: " + value2);

        int multiply = multiplyByTenFunction.apply(value2);
        System.out.println("Multiply with Function: " + multiply);
        // or
        Function<Integer, Integer> addByOneAndMultiplyByTen = incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println("Add and multiply with Function: " + addByOneAndMultiplyByTen.apply(1));

        // with BiFunction
        int result = incrementByOneAndMultiply(1, 10);
        System.out.println("Add and multiply with regular function: " + result);
        int result2 = incrementByOneAndMultiplyBiFunction.apply(1, 10);
        System.out.println("Add and multiply with BiFunction: " + result2);

    }

    // Function - function that accepts only one argument and returns a result
    // accepts Integer - first generic value
    // returns Integer - second generic value
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    // BiFunction - function that takes two arguments and returns one result
    // accepts two Integer
    // returns an Integer
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (number, multiplier) -> (number + 1) * multiplier;

    // regular function
    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int multiplier) {
        return (number + 1) * multiplier;
    }
}
