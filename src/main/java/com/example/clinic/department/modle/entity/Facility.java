package com.example.clinic.department.modle.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "facilities")
@Builder
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "facility_analysis",
            joinColumns = @JoinColumn(name = "analysis_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facility_id", referencedColumnName = "id")
    )
    private Set<Analysis> analysis = new HashSet<>();
}

