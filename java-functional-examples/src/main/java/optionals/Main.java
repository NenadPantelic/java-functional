package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example 1");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        // present = !empty
        System.out.println("Is present = " + empty.isPresent());
        System.out.println("Is empty = " + empty.isEmpty());

        System.out.println("Example 2");
        // NOTE: must accept non-null value
        Optional<Object> optional = Optional.of("hello");
        System.out.println(optional);

        System.out.println("Is present = " + optional.isPresent());
        System.out.println("Is empty = " + optional.isEmpty());


        // orElse(defaultValue):
        // if (empty.isPresent())
        // use that value
        // else:
        // use defaultValue
        System.out.println(empty.orElse("Default value"));
        System.out.println(optional.orElse("Default value2"));

        // NOTE: Optional.ofNullable(T value)
        // accepts null, as well as non-null  value, while Optional.of accepts only non-null values
        //Optional<String> value = Optional.ofNullable("hello, world!");
        Optional<String> value = Optional.ofNullable(null);
        String innerValue = value
                .map(String::toUpperCase)
                .orElse("hi there!");
        System.out.println(innerValue);


        // other manipulations
        String innerValue2 = value
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // some extra computation -  to provide custom result
                    return ("hi-hi".length() % 2 == 0) ? "hi-ho" : "ho-hi";
                });
        System.out.println(innerValue2);

        // throw an exception
//        String innerValue3 = value
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalArgumentException::new);
//        System.out.println(innerValue3);

        // get if present
        Optional.ofNullable(null).ifPresent(System.out::println);

        Optional.ofNullable(null).ifPresentOrElse(System.out::println, () -> System.out.println("Empty optional"));

        // or
        Optional<String> opt = Optional.ofNullable(null);
        String val;
        if (opt.isPresent()) {
            val = opt.get();
        } else {
            val = "unknown";
        }
        System.out.println(val);

    }

}
