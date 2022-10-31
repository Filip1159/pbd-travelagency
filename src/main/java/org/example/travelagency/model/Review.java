package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import static org.example.travelagency.util.RandomUtils.randomInt;
import static org.example.travelagency.util.RandomUtils.randomString;

@Data
@AllArgsConstructor
@DependsOn({Booking.class, Program.class})
public class Review {
    private String title;
    private Integer points;
    private String description;
    private Long fk_booking_id;
    private Long fk_program_id;

    public static Review random(Long fk_booking_id, Long fk_program_id) {
        return new Review(
                randomString(20, 30),
                randomInt(1, 5),
                randomString(200, 500),
                fk_booking_id,
                fk_program_id
        );
    }
}
