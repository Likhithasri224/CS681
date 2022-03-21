package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("BMW","X7", 2022, 8, 74900);
        Car car2 = new Car("Lexus", "NX250", 2020, 15, 39500);
        Car car3 = new Car("Tesla", "Model S", 2021, 20, 85000);
        Car car4 = new Car("Ford","Ranger", 2018, 12, 40000);
        Car car5 = new Car("Audi", "Q7",2021, 10, 61500);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        cars.forEach((Car car) -> car.setDominationCount(cars));

        List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

        System.out.println("\n      Sorted by Price \n");
        sortByPrice.forEach((Car car) -> System.out.println( car.getMake() + ", "+car.getModel() + ": " + car.getPrice()));

        List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
        System.out.println("\n       Sorted by Year \n");
        sortByYear.forEach((Car car) -> System.out.printf("%4s, %s :%6d \n", car.getMake(),car.getModel(), car.getYear()));

        List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage)).collect(Collectors.toList());
        System.out.println("\n       Sorted by Mileage \n");
        sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": " + car.getMileage()));

        List<Car> sortByDomination = cars.stream().sorted(Comparator.comparing(Car::getDominationCount)).collect(Collectors.toList());
        System.out.println("\n       Sorted by Domination \n");
        sortByDomination.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": "+ car.getDominationCount()));

    }

}