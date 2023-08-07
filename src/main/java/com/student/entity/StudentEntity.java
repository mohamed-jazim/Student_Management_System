package com.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_tb")

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fname", length = 100)
    private String first_name;

    @Column(name = "sname",length = 100)
    private String second_name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "pass",length = 100)
    private String password;



}
