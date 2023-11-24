package org.ckb.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dob;
}
