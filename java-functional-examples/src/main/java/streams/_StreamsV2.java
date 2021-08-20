package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _StreamsV2 {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Toyota Corolla", "blue", 2000),
                new Car("Renault Clio", "black", 2004),
                new Car("Volkswagen Beetle", "red", 1987),
                new Car("Ford Fiesta", "blue", 2008));


        // save only cars produced before 2000
        List<Car> carsOlderThan2000 = filterCarsOlderThan2000(cars);
        System.out.println(carsOlderThan2000);

        // print only model name
        printOnlyUniqueModelName(cars);

        // other cool things :-)
        otherCoolThings(cars);

        // make a flat map
        makeAFlatMap(cars, carsOlderThan2000).forEach(System.out::println);

        // sort by year of production
        sortByYearOfProduction(cars).forEach(System.out::println);

        // sort by year of production
        sortByYearOfProductionReversed(cars).forEach(System.out::println);

        // convert to map
        System.out.println(convertToMap(cars));

        List<Car> anotherCarList = new ArrayList<Car>();
        anotherCarList.addAll(cars);
        anotherCarList.add(new Car("Peaugeout 206", "blue", 2004));
        anotherCarList.add(new Car("BMW X6", "black", 2000));

        Car blackCar = findAndFilter(anotherCarList);
        System.out.println(blackCar);

        System.out.println("areAllCarsYoungerThanYear(cars, 1970) = " +
                areAllCarsYoungerThanYear(cars, 1970));

        System.out.println("isAnyCarYoungerThanYear(cars, 2009) = " +
                isAnyCarYoungerThanYear(cars, 2009));
        System.out.println("Total cars value=" + totalValue(cars));

        ifTCarPresent(cars);
        parallelStream(cars);

    }

    // filter out other cars (produced after 1999)
    static List<Car> filterCarsOlderThan2000(List<Car> cars) {
        return cars.stream().filter(car -> car.getYearOfProduction() < 2000).collect(Collectors.toList());
    }

    static void printOnlyUniqueModelName(List<Car> cars) {
        cars.stream().map(Car::getModel).distinct().forEach(System.out::println);
    }

    static void otherCoolThings(List<Car> cars) {
        // distinct values
        System.out.println(cars.stream().distinct().count());

        // limit values
        System.out.println(
                cars.stream()
                        .filter(car -> car.getYearOfProduction() > 1970 && car.getYearOfProduction() < 2007)
                        .limit(2)
                        .collect(Collectors.toList()));
    }

    static List<Car> makeAFlatMap(List<Car> cars1, List<Car> cars2) {
        List<List<Car>> carsNested = List.of(cars1, cars2);
        return carsNested.stream().flatMap(car -> car.stream()).collect(Collectors.toList());

    }

    static List<Car> sortByYearOfProduction(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getYearOfProduction))
                .collect(Collectors.toList());
    }

    static List<Car> sortByYearOfProductionReversed(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getYearOfProduction).reversed())
                .collect(Collectors.toList());
    }


    static Map<String, Car> convertToMap(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.toMap(Car::getModel, Function.identity()));
    }

    static Car findAndFilter(List<Car> cars) {
        // instead of findFirst, we can use findAny to get any result
        return cars.stream()
                .filter(car -> car.getColor().equals("blue"))
                .findFirst().orElse(null);
    }

    static boolean areAllCarsYoungerThanYear(List<Car> cars, int year) {
        return cars.stream().allMatch(car -> car.getYearOfProduction() > year);
    }


    static boolean isAnyCarYoungerThanYear(List<Car> cars, int year) {
        return cars.stream().anyMatch(car -> car.getYearOfProduction() > year);
    }

    static double totalValue(List<Car> cars) {
        return cars.stream()
                .mapToDouble(car -> car.getValue())
                .reduce(0, (sum, val) -> sum + val);
    }

    static void ifTCarPresent(List<Car> cars) {
        cars
                .stream()
                .filter(car -> car.getModel().startsWith("T"))
                .findAny()
                .ifPresent(car -> System.out.println(car.getModel()));
    }

    static void parallelStream(List<Car> cars) {
        // stream is parallelized and in that way it works with multiple threads
        // that means, the first thread which finds the result will return it (non-deterministic result)
        cars
                .parallelStream()
                .filter(car -> car.getColor().startsWith("b"))
                .findAny()
                .ifPresent(car -> System.out.println(car.getModel()));
    }

}
