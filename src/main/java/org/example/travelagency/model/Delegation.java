package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static org.example.travelagency.util.RandomGenerator.randomRole;

@Data
@AllArgsConstructor
public class Delegation {
    private String role;
    private Long fk_employee_id;
    private Long fk_tour_id;

    public static Delegation random() {
        return new Delegation(
                randomRole(),
                0L,
                0L
        );
    }
}
