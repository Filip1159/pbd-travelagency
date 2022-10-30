package org.example.travelagency.model;

import lombok.Data;

@Data
public class KnowledgeOfLanguages {
    private Long fk_employee_id;
    private Long fk_language_id;
}
