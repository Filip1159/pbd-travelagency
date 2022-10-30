package org.example.travelagency.model;

import lombok.Data;

@Data
public class Participant {
    private String document_nr;
    private String surname;
    private String first_name;
    private String second_name;
    private String sex;
    private String email;
    private Long fk_booking_id;
}
