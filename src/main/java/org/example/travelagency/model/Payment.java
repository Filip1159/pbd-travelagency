package org.example.travelagency.model;

import lombok.Data;

@Data
public class Payment {
    private Long fk_customer_id;
    private Long fk_booking_id;
    private String value;
}
