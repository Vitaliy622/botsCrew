package com.botsCrew.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "ENUM('ASSISTANT', 'ASSOCIATE_PROFESSOR', 'PROFESSOR')")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(name = "salary")
    private int salary;

    public Lector(String name, Degree degree, int salary) {
        this.name = name;
        this.degree = degree;
        this.salary = salary;
    }

    public Lector() {
    }
}
