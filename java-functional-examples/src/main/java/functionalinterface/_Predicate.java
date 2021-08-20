package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("With regular function");
        System.out.println(isPhoneNumberValid("06123456789"));
        System.out.println(isPhoneNumberValid("07123456789"));
        System.out.println(isPhoneNumberValid("061234567890"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("06123456789"));
        System.out.println(isPhoneNumberValidPredicate.test("07123456789"));
        System.out.println(isPhoneNumberValidPredicate.test("061234567890"));

        // chained predicates
        System.out.println("With predicates chaining");
        // and - logical and
        // or - logical or
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("06123456789"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07123456789"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("061234567890"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("06122456789"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("06122456789"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("061234567890"));

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("06") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("06") && phoneNumber.length() == 11;


    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
