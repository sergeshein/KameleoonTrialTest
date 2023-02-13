package com.shein.KameleoonTrialTest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DelEnt")
public class DelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;
}
