package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "Planet")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String demonym;
    private Long population;
    private String geography;
    private String description;

    @OneToMany(mappedBy = "planet")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    private Set<DemographicsMapping> demographicsMappings;

}
