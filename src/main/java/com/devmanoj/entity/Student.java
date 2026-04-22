package com.devmanoj.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;
    private Integer english;
    private Integer hindi;
    private Integer math;
    private Integer science;
}