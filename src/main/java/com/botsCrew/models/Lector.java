package com.botsCrew.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "LECTOR")
public class Lector {

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "ENUM('ASSISTANT', 'ASSOCIATE_PROFESSOR', ' PROFESSOR')")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "lector")
    private List<Department> departments = new ArrayList<>();
}
