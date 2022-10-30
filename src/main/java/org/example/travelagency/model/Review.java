package org.example.travelagency.model;

import lombok.Data;

@Data
public class Review {
    private String title;
    private Integer points;
    private String description;
    private Long fk_booking_id;
    private Long fk_program_id;
}
