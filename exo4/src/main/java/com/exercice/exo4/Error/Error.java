package com.exercice.exo4.Error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String message;
    private int code;
    private LocalDateTime timestamp;
}
