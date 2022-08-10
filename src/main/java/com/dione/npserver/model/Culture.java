package com.dione.npserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Culture")
public class Culture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String demonym;
    private String description;
}
