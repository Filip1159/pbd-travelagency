package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomShort;
import static org.example.travelagency.util.RandomGenerator.randomString;

@Data
@AllArgsConstructor
public class Employee {
    private String document_nr;
    private String surname;
    private String first_name;
    private String second_name;
    private String sex;
    private String department;
    private String login;
    private String password;
    private Long fk_institution_id;

    public static Employee random() {
        return new Employee(
                randomString(10, 13),
                randomString(5, 15),
                randomString(5, 15),
                randomString(5, 15),
                randomShort(0, 1) == 0 ? "K" : "M",
                randomString(10, 20),
                randomString(10, 20),
                randomString(8, 20),
                0L
            );
    }
}
