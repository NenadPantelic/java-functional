package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("With regular function");
        System.out.println(getDBConnectionUrl());
        // with supplier
        System.out.println("With supplier");
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlsSupplier.get());

    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    // generic argument -> what kind of result it is going to supply
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlsSupplier = () ->
            List.of("jdbc://localhost:5432/user", "jdbc://localhost:5432/customer");
}
