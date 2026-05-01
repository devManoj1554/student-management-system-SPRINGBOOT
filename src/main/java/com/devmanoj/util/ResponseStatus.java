package com.devmanoj.util;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus<T> {
    private int status;
    private String message;
    private T data;
}