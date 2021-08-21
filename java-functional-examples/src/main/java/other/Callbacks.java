package other;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        System.out.println("Example 1");
        hello("John", "Montana", null);
        System.out.println("Example 2");
        hello("John", null, value -> {
            System.out.printf("lastName not provided for %s!\n", value);
        });
        System.out.println("Example 3");
        helloWithRunnable("John",
                null,
                () -> System.out.println("lastName not provided!"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void helloWithRunnable(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
