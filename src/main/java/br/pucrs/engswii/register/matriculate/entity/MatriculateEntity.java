package br.pucrs.engswii.register.matriculate.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matriculate")
public class MatriculateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "registration_student")
    Long registrationStudent;
    @Column(name = "subject_code")
    String subjectCode;
    @Column(name = "subject_class")
    Long subjectClass;
}