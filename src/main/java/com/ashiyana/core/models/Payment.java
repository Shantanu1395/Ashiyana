package com.ashiyana.core.models;

import com.ashiyana.core.enums.PaymentStatus;
import com.ashiyana.core.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Payment {

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
    private String payment_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "plot_transaction_id")
    private PlotTransaction plotTransaction;

    private double amount;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "transaction_date")
    private Date transactionDate;

}
