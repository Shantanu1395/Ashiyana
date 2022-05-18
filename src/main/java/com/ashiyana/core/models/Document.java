package com.ashiyana.core.models;

import com.ashiyana.core.enums.DocumentStatus;
import com.ashiyana.core.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(length = 45)
    private String name;

    @Column(name = "issue_date")
    private Date issueDate;

    @Enumerated(EnumType.STRING)
    private DocumentStatus documentStatus;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "plot_transaction_id")
    private PlotTransaction plotTransaction;
}

