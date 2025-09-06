package com.student.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    private int age;
}
