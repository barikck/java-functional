package org.ckb.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface CustomerRegValidator extends Function<Customer, ValidationResult> {

    static CustomerRegValidator isValidEmail() {
        return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegValidator isValidPhoneNumber() {
        return customer -> customer.getPhoneNumber().startsWith("+91") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18
                ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegValidator and(CustomerRegValidator other) {
        return customer -> {
            ValidationResult validationResult = this.apply(customer);
            return validationResult.equals(ValidationResult.SUCCESS) ? other.apply(customer) : validationResult;
        };
    }

    static List<ValidationResult> validateCustomer(Customer customer) {
        List<ValidationResult> results = new ArrayList<>();
        results.add(isValidEmail().apply(customer));
        results.add(isValidPhoneNumber().apply(customer));
        results.add(isAdult().apply(customer));
        return results;
    }
}
