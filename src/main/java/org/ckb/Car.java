package org.ckb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
class Car {
    int model;
    double price;

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(1999, 5000.0),
                new Car(1999, 50000.0),
                new Car(2022, 10000.0),
                new Car(2022, 1000.0)
        );
        //o/p: Car(1999, 5000.0)

        Optional<Car> cheapestOfLowestModel = cars.stream()
                .filter(car -> car.getModel() == cars.stream().mapToInt(Car::getModel).min().orElseThrow())
                .min(Comparator.comparingDouble(Car::getPrice));


    }
}


