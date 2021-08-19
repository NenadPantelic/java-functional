package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Person.Gender.MALE),
                new Person("Maria", Person.Gender.FEMALE),
                new Person("Aysha", Person.Gender.FEMALE),
                new Person("Alex", Person.Gender.MALE),
                new Person("Alice", Person.Gender.FEMALE),
                new Person("Jay", Person.Gender.OTHER)
        );

        // 1. imperative approach
        List<Person> females = new ArrayList<Person>();
        System.out.println("Imperative approach");
        for (Person person : people) {
            if (person.gender.equals(Person.Gender.FEMALE)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("Declarative approach");
        // 2. declarative approach
        List<Person> females2 = people
                .stream()
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

        /*
        I: functional interfaces: interface with only one abstract method, but can have multiple default methods
        a) predicate: boolean-valued function with one argument
        b) function: function that accepts one argument and produces a result
        */


        // predicate
        System.out.println("With predicate!");
        Predicate<Person> personGenderPredicate = person -> person.getGender().equals(Person.Gender.FEMALE);
        people
                .stream()
                .filter(personGenderPredicate)
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        enum Gender {
            MALE,
            FEMALE,
            OTHER
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}
