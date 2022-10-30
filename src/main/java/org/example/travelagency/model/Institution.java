package org.example.travelagency.model;

import lombok.Data;

@Data
public class Institution {
    private String name;
    private String type;
    private String description;
    private String hours;
    private String address;
    private String tel;
}
