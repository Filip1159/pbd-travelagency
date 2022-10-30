package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomString;

@Data
@AllArgsConstructor
public class Photo {
    private String path_name;
    private Long fk_institution_id;
    private Long fk_program_id;

    private static Photo random() {
        return new Photo(
                randomString(30, 100),
                0L,
                0L
        );
    }
}
