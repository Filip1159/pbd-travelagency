package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

import static org.example.travelagency.util.RandomGenerator.*;

@Data
@AllArgsConstructor
public class Booking {
    private Date date;
    private Short is_paid;
    private Integer participants_nr;
    private Long fk_tour_id;

    public static Booking random() {
        return new Booking(
                randomDate(Instant.parse("2018-11-30T18:35:24.00Z"), Instant.parse("2018-11-30T18:35:24.00Z")),
                randomShort(0, 1),
                randomInt(1, 5),
                0L
        );
    }
}
