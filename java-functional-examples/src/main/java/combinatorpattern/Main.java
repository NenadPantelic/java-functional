package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0123456789",
                LocalDate.of(2000, 1, 1));

        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValid(customer));

        // combinator pattern -> function that can accept other functions as arguments and return functions
        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                // lazy evaluation until apply is called
                .apply(customer);
        System.out.println(result);

        if (!result.equals(ValidationResult.SUCCESS)) {
            throw new IllegalStateException(result.name());
        }
    }
}
