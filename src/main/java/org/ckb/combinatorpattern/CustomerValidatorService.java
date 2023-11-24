package org.ckb.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    private static boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }

    public static boolean isValid(Customer customer) {
        return isValidEmail(customer.getEmail()) &&
                isValidPhoneNumber(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }


}
