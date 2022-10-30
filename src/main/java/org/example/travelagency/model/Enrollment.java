package org.example.travelagency.model;

import lombok.Data;

@Data
public class Enrollment {
    private Long fk_booking_id;
    private Long fk_attraction_id;
}
