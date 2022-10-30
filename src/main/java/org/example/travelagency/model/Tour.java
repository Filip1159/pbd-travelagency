package org.example.travelagency.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tour {
    private Float price;
    private Date date;
    private Integer max_participants_nr;
    private Long fk_program_id;
}
