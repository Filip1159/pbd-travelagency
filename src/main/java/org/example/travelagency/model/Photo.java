package org.example.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.travelagency.DependsOn;
import org.example.travelagency.Optional;

import static org.example.travelagency.util.RandomUtils.randomString;

@Data
@AllArgsConstructor
@DependsOn({Institution.class, Program.class})
public class Photo {
    private String path_name;
    private Long fk_institution_id;
    private Long fk_program_id;

    public static Photo random(@Optional Long fk_institution_id, @Optional Long fk_program_id) {
        return new Photo(
                randomString(30, 100),
                fk_institution_id,
                fk_program_id
        );
    }
}
