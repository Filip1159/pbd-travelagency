package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import java.time.Instant;
import java.util.Date;

import static org.example.travelagency.util.RandomUtils.*;

@Data
@AllArgsConstructor
@DependsOn(Tour.class)
public class Booking {
    private Date date;
    private Short is_paid;
    private Integer participants_nr;
    private Long fk_tour_id;

    public static Booking random(Long fk_tour_id) {
        return new Booking(
                randomDate(Instant.parse("2018-01-01T12:00:00.00Z"), Instant.parse("2022-12-31T12:00:00.00Z")),
                randomShort(0, 1),
                randomInt(1, 5),
                fk_tour_id
        );
    }
}
