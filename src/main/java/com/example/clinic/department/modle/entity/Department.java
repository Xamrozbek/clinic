package com.example.clinic.department.modle.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "department_facilities",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "facility_id", referencedColumnName = "id"))
    private Set<Facility> facilities = new HashSet<>();
}
