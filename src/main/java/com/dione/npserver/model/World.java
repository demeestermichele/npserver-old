package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "World")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String star;
    private String demonym;
    private Long population;

    @OneToMany(mappedBy = "world")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    private List<DemographicsMapping> demographicsMappings;
}
