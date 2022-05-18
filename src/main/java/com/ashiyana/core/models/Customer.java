package com.ashiyana.core.models;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class Customer {

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

    @Column(length = 45)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(name = "primary_contact", length = 15)
    private String primaryContact;

    @Column(name = "secondary_contact", length = 15)
    private String secondaryContact;

    @Column(length = 12)
    private String aadhar;
}
