package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "123456789");
        // regular Java function
        greetCustomer(customer);
        // with consumer
        greetCustomerConsumer.accept(customer);
        // with bi-consumer
        greetCustomerConsumerV2.accept(customer, true);
        greetCustomerConsumerV2.accept(customer, false);

    }

    // BiConsumer - two arguments, no result
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.printf("Hello %s, thanks for registering phone number %s.%n", customer.name,
                    showPhoneNumber ? customer.phoneNumber : "*********");

    // Consumer - one argument, no result
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.printf("Hello %s, thanks for registering phone number %s.%n", customer.name, customer.phoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.printf("Hello %s, thanks for registering phone number %s.%n", customer.name, customer.phoneNumber);
    }

    static class Customer {
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
