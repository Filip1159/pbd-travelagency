package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import java.time.Instant;
import java.util.Date;

import static org.example.travelagency.util.RandomUtils.*;

@Data
@AllArgsConstructor
@DependsOn(Program.class)
public class Tour {
    private Float price;
    private Date date;
    private Integer max_participants_nr;
    private Long fk_program_id;

    public static Tour random(Long fk_program_id) {
        return new Tour(
                randomFloat(1000, 5000),
                randomDate(Instant.parse("2018-01-01T12:00:00.00Z"), Instant.parse("2022-12-31T12:00:00.00Z")),
                randomInt(15, 100),
                fk_program_id
        );
    }
}
