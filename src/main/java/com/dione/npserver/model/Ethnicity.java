package com.dione.npserver.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ethnicity")
public class Ethnicity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Long population;
    private String description;
}
