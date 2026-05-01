package com.devmanoj.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
    private Integer studentId;
    private String name;
    private Integer totalMarks;
    private Double percentage;
}