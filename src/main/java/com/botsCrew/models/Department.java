package com.botsCrew.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "departments_lectors",
            joinColumns = {
                    @JoinColumn(name = "department_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "lector_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Lector> lectors = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "headOfDepartment_id", referencedColumnName = "id", nullable = true)
    private Lector headOfDepartment;

    public Department(String name, Lector headOfDepartment) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
    }

    public Department() {
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lectors=" + lectors +
                ", headOfDepartment=" + headOfDepartment +
                '}';
    }
}
