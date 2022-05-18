package com.ashiyana.core.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class PlotTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "tracking_id", updatable = false, nullable = false)
    private UUID trackingId;

    @Column(name = "cost_to_pay")
    private double costToPay;

    @Column(name = "cost_paid")
    private double costPaid;

    //documentId - 1:m
    @JsonManagedReference
    @OneToMany(mappedBy = "plotTransaction")
    List<Document> documents = new ArrayList<>();

    //paymentId - 1:m
    @JsonManagedReference
    @OneToMany(mappedBy = "plotTransaction")
    List<Payment> payments = new ArrayList<>();

    //plotId - m:1
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    //CustomerId - m:1
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
