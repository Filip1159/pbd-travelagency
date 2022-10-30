package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomInt;
import static org.example.travelagency.util.RandomGenerator.randomString;

@Data
@AllArgsConstructor
public class Review {
    private String title;
    private Integer points;
    private String description;
    private Long fk_booking_id;
    private Long fk_program_id;

    public static Review random() {
        return new Review(
                randomString(20, 40),
                randomInt(1, 5),
                randomString(200, 500),
                0L,
                0L
        );
    }
}
