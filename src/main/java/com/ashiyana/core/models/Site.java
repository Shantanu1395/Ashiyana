package com.ashiyana.core.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(length = 45)
    private String name;

    @Column(length = 100)
    private String address;

    private double area;

    @JsonManagedReference
    @OneToMany(mappedBy = "site")
    List<Plot> plots = new ArrayList<>();
}
