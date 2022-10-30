package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.*;

@Data
@AllArgsConstructor
public class Customer {
    private String document_nr;
    private String surname;
    private String first_name;
    private String second_name;
    private String sex;
    private String department;
    private String login;
    private String password;
    private String email;

    public static Customer random() {
        return new Customer(
                randomString(10, 13),
                randomString(5, 15),
                randomString(5, 15),
                randomString(5, 15),
                randomShort(0, 1) == 0 ? "K" : "M",
                randomString(10, 20),
                randomString(10, 15),
                randomString(8, 30),
                randomEmail()
        );
    }
}
