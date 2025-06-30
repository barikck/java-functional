package org.ckb;

import org.ckb.combinatorpattern.Customer;
import org.ckb.combinatorpattern.CustomerRegValidator;
import org.ckb.combinatorpattern.CustomerValidatorService;
import org.ckb.combinatorpattern.ValidationResult;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

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

        StringBuilder sb = new StringBuilder();
        System.out.println("sb = " + sb.toString().isEmpty());

        // Using StringBuilder to collect names
        String names = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
        System.out.println("names = " + names);

        // Using StringBuilder to collect names with a custom delimiter
        String namesWithDelimiter = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(" | ", "Names: ", "."));
        System.out.println("namesWithDelimiter = " + namesWithDelimiter);

        // Using StringBuilder to collect names with a custom prefix and suffix
        String namesWithPrefixSuffix = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
        System.out.println("namesWithPrefixSuffix = " + namesWithPrefixSuffix);

        //other examples of stream operations
        List<String> namesList = people.stream()
                .map(Person::getName)
                .toList();
        System.out.println("namesList = " + namesList);

        List<String> namesUpperCase = people.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .toList();
        System.out.println("namesUpperCase = " + namesUpperCase);

        List<Integer> ages = people.stream()
                .map(Person::getAge)
                .toList();
        System.out.println("ages = " + ages);

        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();
        System.out.println("sortedByAge = " + sortedByAge);

        List<Person> sortedByName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
        System.out.println("sortedByName = " + sortedByName);

        // Using flatMap to flatten a list of lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "F")
        );
        List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("flattenedList = " + flattenedList);

        // Using flatMap to flatten a list of lists of integers
        List<List<Integer>> listOfIntegerLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<Integer> flattenedIntegerList = listOfIntegerLists.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("flattenedIntegerList = " + flattenedIntegerList);

        // Using flatMap to flatten a list of lists of Person objects
        List<List<Person>> listOfPersonLists = people.stream()
                .collect(Collectors.groupingBy(Person::getGender))
                .values()
                .stream()
                .toList();
        List<Person> flattenedPersonList = listOfPersonLists.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("flattenedPersonList = " + flattenedPersonList);


        //complex example
        List<Person> complexPeople = people.stream()
                .filter(person -> person.getAge() > 18)
                .sorted(Comparator.comparing(Person::getName))
                .map(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()))
                .toList();
        System.out.println("complexPeople = " + complexPeople);

        // Using a custom collector to collect names into a StringBuilder
        StringBuilder namesCollector = people.stream()
                .map(Person::getName)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("namesCollector = " + namesCollector.toString());

        // Using a custom collector to collect names into a StringBuilder with a custom delimiter
        String namesWithDelimiterCollector = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(" | "));
        System.out.println("namesWithDelimiterCollector = " + namesWithDelimiterCollector);

        IntStream.range(0, 10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        // Using IntStream to generate a range of numbers
        List<Integer> rangeList = IntStream.range(1, 11) // Generates numbers from 1 to 10 (exclusive)
                .boxed() // Convert IntStream to Stream<Integer>
                .toList();

        System.out.println("rangeList = " + rangeList);

        // Using IntStream to generate a range of numbers with a step
        List<Integer> stepRangeList = IntStream.iterate(1, num -> num + 2) // Generates odd numbers starting from 1
                .limit(10) // Limit to the first 10 elements
                .boxed() // Convert IntStream to Stream<Integer>
                .toList();
        System.out.println("stepRangeList = " + stepRangeList);

        // Using IntStream to generate a range of numbers and perform operations
        List<Integer> squaredList = IntStream.range(1, 11) // Generates numbers from 1 to 10 (exclusive)
                .map(num -> num * num) // Square each number
                .boxed()
                .toList();
        System.out.println("squaredList = " + squaredList);

        String s = "abcba";
        //pallindrome check using streams
        boolean isPalindromeStream = IntStream.range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
        System.out.println("isPalindrome = " + isPalindromeStream);

        //complex predicates in streams
        Predicate<Person> isAdult = person -> person.getAge() >= 18;
        Predicate<Person> isMale = person -> person.getGender().equals(Gender.MALE);
        Predicate<Person> isAdultMale = isAdult.and(isMale);
        List<Person> adultMales = people.stream()
                .filter(isAdultMale)
                .toList();
        System.out.println("adultMales = " + adultMales);

        //complex predicates with or condition
        Predicate<Person> isFemaleOrAdult = isFemalePredicate.or(isAdult);
        List<Person> femalesOrAdults = people.stream()
                .filter(isFemaleOrAdult)
                .toList();
        System.out.println("femalesOrAdults = " + femalesOrAdults);

        //complex predicates with not condition
        Predicate<Person> isNotAdult = isAdult.negate();
        List<Person> notAdults = people.stream()
                .filter(isNotAdult)
                .toList();
        System.out.println("notAdults = " + notAdults);

         //using function composition
        Function<Person, String> getNameFunction = Person::getName;
        Function<Person, String> getNameUpperCaseFunction = getNameFunction.andThen(String::toUpperCase);
        List<String> upperCaseNames = people.stream()
                .map(getNameUpperCaseFunction)
                .toList();
        System.out.println("upperCaseNames = " + upperCaseNames);

        //Using biFunction to combine two integers
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        int a = 4, b = 5;
        int product = multiply.apply(a, b);
        System.out.println("Product of " + a + " and " + b + " is: " + product);

        //Using binary operator to find maximum of two integers
        BinaryOperator<Integer> maxOperator = Integer::max;
        int x = 10, y = 20;
        int max = maxOperator.apply(x, y);
        System.out.println("Maximum of " + x + " and " + y + " is: " + max);

        //Using unary operator to increment an integer
        UnaryOperator<Integer> increment = num -> num + 1;
        int number = 5;
        int incrementedNumber = increment.apply(number);
        System.out.println("Incremented value of " + number + " is: " + incrementedNumber);

        //Using consumer to print a message
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        String message = "Hello, World!";
        printMessage.accept(message);

        //Using supplier to generate a random number
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        int randomNumber = randomNumberSupplier.get();
        System.out.println("Random number: " + randomNumber);
    }
}

