package org.example.travelagency.model;

import lombok.Data;

@Data
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
}
