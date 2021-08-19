import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // 1. filter
        // imperative approach
        List<Person> females = new ArrayList<Person>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        System.out.println();
        // declarative approach
        List<Person> females2 = people
                .stream()
                // filter accepts predicate -> return true or false
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
        System.out.println();
        // 2. sort (by age)
        List<Person> peopleSortedByAge = people
                .stream()
                // accepts Comparator
                .sorted(Comparator.comparing(Person::getAge))
//                        .thenComparing(Person::getName) // chained comparison
//                        .reversed())            // reverse order
                .collect(Collectors.toList());
        peopleSortedByAge.forEach(System.out::println);

        // 3. All match
        boolean allOlderThanTwentyFive = people
                .stream()
                .allMatch(person -> person.getAge() > 25);
        System.out.println(String.format("Are all people older than 25? %b", allOlderThanTwentyFive));

        // 4. Any match
        boolean anyOlderThanTwentyFive = people
                .stream()
                .anyMatch(person -> person.getAge() > 25);
        System.out.println(String.format("Is there any person older than 25? %b", anyOlderThanTwentyFive));

        // 5. None match
        boolean antonioNotExist = people
                .stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(String.format("Does 'Antonio' exist? %b", antonioNotExist));

        // 6. Min and Max
        System.out.print("Person with min age=");
        people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        System.out.print("Person with max age=");
        people
                .stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // 7. Group
        System.out.println("People grouped by gender!");
        Map<Gender, List<Person>> groupByGender = people
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        // 8. Chaining
        Optional<String> oldestFemaleAge = people
                .stream()
                // keep only those that satisfy the condition
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                // get the object with the highest value of the age
                .max(Comparator.comparing(Person::getAge))
                // map object to only name (String)
                .map(Person::getName);
        System.out.print("The oldest female: ");
        oldestFemaleAge.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 32, Gender.FEMALE),
                new Person("Helen White", 28, Gender.FEMALE),
                new Person("Alex Boz", 26, Gender.OTHER),
                new Person("Jamie Goa", 34, Gender.MALE),
                new Person("John Doe", 31, Gender.MALE),
                new Person("Gretta Dawson", 38, Gender.FEMALE),
                new Person("Alice Lay", 29, Gender.FEMALE),
                new Person("Greg Jameson", 34, Gender.MALE)
        );
    }
}
