package org.example.travelagency.model;

import lombok.Data;

@Data
public class Delegation {
    private String role;
    private Long fk_employee_id;
    private Long fk_tour_id;
}
