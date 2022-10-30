package org.example.travelagency.model;

import lombok.Data;

@Data
public class Attraction {
    private String title;
    private Float price;
    private String description;
    private Long fk_program_id;
    private Long fk_institution_id;
}
