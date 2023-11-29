package org.ckb;

import org.ckb.combinatorpattern.Customer;
import org.ckb.combinatorpattern.CustomerRegValidator;
import org.ckb.combinatorpattern.CustomerValidatorService;
import org.ckb.combinatorpattern.ValidationResult;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Aston", Gender.MALE, 18),
                new Person("Emily", Gender.FEMALE, 16),
                new Person("Rose", Gender.FEMALE, 22),
                new Person("Sam", Gender.MALE, 21),
                new Person("Thomas", Gender.MALE, 20)
        );

        //Imparative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people)
            if (person.getGender().equals(Gender.FEMALE)) females.add(person);

        for (Person person : females)
            System.out.println(person);

        //Declarative approach
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .forEach(System.out::println);

        Function<Integer, Integer> square = num -> num * num;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        int n = 3, m = 5;
        System.out.println("Square of " + n + " is: " + square.apply(n));
        System.out.println(n + "^2 + " + m + " = " + add.apply(square.apply(n), m));

        Consumer<Person> displayPersonConsumer = person -> System.out.println("Hi " + person.getName() + "...");
        displayPersonConsumer.accept(people.get(0));

        Supplier<String> welcomeMsgSupplier = () -> "Hello world!!!...";
        System.out.println(welcomeMsgSupplier.get());

        Predicate<Person> isFemalePredicate = person -> person.getGender().equals(Gender.FEMALE);
        System.out.println(people.stream().allMatch(isFemalePredicate));


        Optional<String> nameOptional = Optional.empty();
        nameOptional
                .ifPresentOrElse(name -> System.out.println("hello " + name),
                        () -> System.out.println("anyone there?"));

        Optional.ofNullable(null)
                .ifPresentOrElse(name -> System.out.println("hello " + name),
                        () -> System.out.println("anyone there?"));

        Optional.ofNullable("Eric")
                .ifPresentOrElse(name -> System.out.println("hello " + name),
                        () -> System.out.println("anyone there?"));

        System.out.println(
                Optional.ofNullable(null)
                .orElse("no-one"))
                ;

        System.out.println(
                Optional.ofNullable("Ryan")
                .orElse("no-one"))
                ;


        System.out.println("Without Combinator Pattern ===============");
        Customer customer = new Customer(
                "Alex",
                "alexabc.com",
                "910123456789",
                LocalDate.of(1990, 1, 1)
        );

        System.out.println(CustomerValidatorService.isValid(customer));

        System.out.println("With Combinator Pattern ===============");
        ValidationResult validationResult = CustomerRegValidator
                .isValidEmail()
                .and(CustomerRegValidator.isValidPhoneNumber())
                .and(CustomerRegValidator.isAdult())
                .apply(customer);

        System.out.println(validationResult);

        System.out.println("Real world scenario ===============");
        List<ValidationResult> failedValidations = CustomerRegValidator.validateCustomer(customer)
                .stream().filter(r -> !r.equals(ValidationResult.SUCCESS)).toList();
        failedValidations.forEach(System.out::println);


        //stream reduce function
        System.out.println(
                people.stream()
                        .reduce(BinaryOperator
                                .maxBy(Comparator.comparingInt(Person::getAge))
                        )
        );

        //grouping
        Map<Gender, List<Person>> personMapByGender = people.stream()
                .collect(groupingBy(Person::getGender));
        System.out.println("personMapByGender = " + personMapByGender);

        Map<Gender, List<String>> mapByGender = people.stream()
                .collect(groupingBy(Person::getGender, mapping(Person::getName, toList())));
        System.out.println("mapByGender = " + mapByGender);


    }
}

