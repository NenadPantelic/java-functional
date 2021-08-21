package other;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        // inline lambda
        Function<String, String> upperCaseName = (name) -> name.toUpperCase();
        Function<String, String> upperCaseName2 = String::toUpperCase;


        // multiline lambda
        Function<String, String> upperCaseNameWithPrint = (name) -> {
            System.out.println("Original name = " + name);
            var upperCasedName = name.toUpperCase();
            System.out.println("Name after upper casing = " + upperCasedName);
            return upperCasedName;
        };

        System.out.println(upperCaseName.apply("nenad"));
        System.out.println(upperCaseName2.apply("nenad"));
        System.out.println(upperCaseNameWithPrint.apply("nenad"));

        // bifunction
        BiFunction<String, Integer, String> func = (name, age) ->{
            if(name.isBlank() || age < 18){
                throw new IllegalArgumentException("Arguments not valid!");
            }
            return String.format("Name = %s, age = %d", name, age);
        };
        System.out.println("BiFunction lambda (two args)");
        System.out.println(func.apply("Nenad", 24));
    }

}
