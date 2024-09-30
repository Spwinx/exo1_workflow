package org.example.spring_exo_etudient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.spring_exo_etudient.validator.MyValidNom;
import org.example.spring_exo_etudient.validator.MyValidPrenom;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "etudient")
public class Etudient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etudient")
    private int id;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @MyValidNom()
    private String nom;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @MyValidPrenom()
    private String prenom;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    private String email;
    @Min(value = 15)
    @Max(40)
    private int age;
    private String image;
}
