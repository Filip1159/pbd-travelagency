package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static org.example.travelagency.util.RandomGenerator.randomFloat;
import static org.example.travelagency.util.RandomGenerator.randomString;

@Getter
@Setter
@AllArgsConstructor
public class Attraction {
    private String title;
    private Float price;
    private String description;
    private long fk_program_id;
    private long fk_institution_id;

    public static Attraction random() {
        return new Attraction(
                randomString(10, 30),
                randomFloat(20, 100),
                randomString(300, 2000),
                0L,
                0L
        );
    }
}
