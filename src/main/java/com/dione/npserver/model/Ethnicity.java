package com.dione.npserver.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Ethnicity")
public class Ethnicity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Long population;
    private String description;

    @OneToMany(mappedBy = "ethnicity")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    private Set<DemographicsMapping> demographicsMappings;

}
