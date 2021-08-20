package streams;

import static streams._Stream.Person.Gender.MALE;
import static streams._Stream.Person.Gender.FEMALE;
import static streams._Stream.Person.Gender.PREFER_NOT_TO_SAY;

import streams._Stream.Person.Gender;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aysha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Jay", PREFER_NOT_TO_SAY)
        );

        System.out.println("Genders:");
        Set<Gender> genders = people
                .stream()
                .map(Person::getGender)
                .collect(Collectors.toSet());
        System.out.println(genders);

        System.out.println("Name lengths:");
        people
                .stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.print("All females? ");
        boolean containsOnlyFemales = people
                .stream()
                .allMatch(person -> person.getGender().equals(FEMALE));
        System.out.println(containsOnlyFemales);

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
            PREFER_NOT_TO_SAY
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
