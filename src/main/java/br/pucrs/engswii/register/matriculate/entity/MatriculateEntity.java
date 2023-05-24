package br.pucrs.engswii.register.matriculate.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "matriculate")
public class MatriculateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "registration_student", nullable = false)
    Long registrationStudent;

    @Column(name = "subject_code", nullable = false)
    String subjectCode;

    @Column(name = "subject_class")
    Long subjectClass;
}