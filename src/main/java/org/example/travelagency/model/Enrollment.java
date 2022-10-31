package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

@Data
@AllArgsConstructor
@DependsOn({Booking.class, Attraction.class})
public class Enrollment {
    private Long fk_booking_id;
    private Long fk_attraction_id;

    public static Enrollment random(Long fk_booking_id, Long fk_attraction_id) {
        return new Enrollment(
                fk_booking_id,
                fk_attraction_id
        );
    }
}
