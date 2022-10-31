package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;
import org.example.travelagency.Optional;

import static org.example.travelagency.util.RandomUtils.randomFloat;
import static org.example.travelagency.util.RandomUtils.randomString;

@Data
@AllArgsConstructor
@DependsOn({Program.class, Institution.class})
public class Attraction {
    private String title;
    private Float price;
    private String description;
    private Long fk_program_id;
    private Long fk_institution_id;

    public static Attraction random(Long fk_program_id, @Optional Long fk_institution_id) {
        return new Attraction(
                randomString(10, 30),
                randomFloat(20, 100),
                randomString(300, 2000),
                fk_program_id,
                fk_institution_id
        );
    }
}
