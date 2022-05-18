package com.ashiyana.core.models;

import com.ashiyana.core.enums.LandUnit;
import com.ashiyana.core.enums.PlotStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "serial_number")
    private int serialNumber;

    @Column(length = 100)
    private String dimention;

    @Enumerated(EnumType.STRING)
    private LandUnit unit;

    private double area;

    private double cost;

    private PlotStatus plotStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

}
