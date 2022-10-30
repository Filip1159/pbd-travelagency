package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

import static org.example.travelagency.util.RandomGenerator.*;

@Data
@AllArgsConstructor
public class Tour {
    private Float price;
    private Date date;
    private Integer max_participants_nr;
    private Long fk_program_id;

    public static Tour random() {
        return new Tour(
                randomFloat(1000, 5000),
                randomDate(Instant.parse(""), Instant.parse("")),
                randomInt(15, 100),
                0L
        );
    }
}
