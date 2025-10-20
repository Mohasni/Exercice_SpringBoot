package com.exercice.exo4.Error;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldError {
    String entityName;
    String fieldName;
    String message;
    String code;
}
