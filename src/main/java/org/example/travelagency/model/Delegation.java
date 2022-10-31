package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;

import static org.example.travelagency.util.RandomUtils.randomRole;

@Data
@AllArgsConstructor
@DependsOn({Employee.class, Tour.class})
public class Delegation {
    private String role;
    private Long fk_employee_id;
    private Long fk_tour_id;

    public static Delegation random(Long fk_employee_id, Long fk_tour_id) {
        return new Delegation(
                randomRole(),
                fk_employee_id,
                fk_tour_id
        );
    }
}
