package org.example.travelagency.model;

import lombok.Data;

@Data
public class Photo {
    private String path_name;
    private Long fk_institution_id;
    private Long fk_program_id;
}
