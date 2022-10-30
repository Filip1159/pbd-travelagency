package org.example.travelagency.model;

import lombok.Data;

import java.util.Date;

@Data
public class Booking {
    private Date date;
    private Short is_paid;
    private Integer participants_nr;
    private Long fk_tour_id;
}
