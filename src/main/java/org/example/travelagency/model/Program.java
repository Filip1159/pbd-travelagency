package org.example.travelagency.model;

import lombok.Data;

@Data
public class Program {
    private String title;
    private Integer days_nr;
    private String transport_type;
    private Short is_abroad;
    private Short is_for_children;
    private String description;
}
