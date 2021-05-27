package com.botsCrew.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DEPARTMENT")
public class Department {
   @Column(name = "department_name")
   private String name;

    @ManyToOne
    @JoinColumn(name = "LECTOR", nullable = false)
    private Lector lector;

    @Column(name = "department_average_salary")
    private Long salary;

    @Column(name = "employee_count")
    private int employeeCount;
}
