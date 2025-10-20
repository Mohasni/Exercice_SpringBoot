package com.exercice.exo4.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le champ name n'est pas valide")
    private String name;
    @NotBlank(message = "Le champ email ne doit pas etre vide")
    @Email(message = "Le champ email n'est pas valide")
    private String email;

}
