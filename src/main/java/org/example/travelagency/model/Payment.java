package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import static org.example.travelagency.util.RandomUtils.randomFloat;

@Data
@AllArgsConstructor
@DependsOn({Customer.class, Booking.class})
public class Payment {
    private Long fk_customer_id;
    private Long fk_booking_id;
    private Float value;

    public static Payment random(Long fk_customer_id, Long fk_booking_id) {
        return new Payment(
                fk_customer_id,
                fk_booking_id,
                randomFloat(1000, 10000)
        );
    }
}
