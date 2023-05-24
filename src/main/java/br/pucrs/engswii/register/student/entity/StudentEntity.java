package br.pucrs.engswii.register.student.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long registrationNumber;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "document_number", unique = true)
    String documentNumber;

    @Column(name = "address")
    String address;
}
