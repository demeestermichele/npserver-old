package com.dione.npserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Demographics_mapping")
public class DemographicsMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn(name="character_id", referencedColumnName="id")
    private Character character;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn(name = "Ethnicity", referencedColumnName = "id")
    private Ethnicity ethnicity;

}
