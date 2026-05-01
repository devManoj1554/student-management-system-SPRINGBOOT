package com.devmanoj.dto;

import lombok.*;

@Getter
@Setter
public class StudentRequestDTO {
    private String name;
    private Integer english;
    private Integer hindi;
    private Integer math;
    private Integer science;
}