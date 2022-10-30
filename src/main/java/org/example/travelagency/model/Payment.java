package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomFloat;

@Data
@AllArgsConstructor
public class Payment {
    private Long fk_customer_id;
    private Long fk_booking_id;
    private Float value;

    public static Payment random() {
        return new Payment(
                0L,
                0L,
                randomFloat(1000, 10000)
        );
    }
}
