package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Enrollment {
    private Long fk_booking_id;
    private Long fk_attraction_id;

    public static Enrollment random() {
        return new Enrollment(
                0L,
                0L
        );
    }
}
