package br.pucrs.engswii.register.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long registrationNumber;

    @Column(name = "name")
    String name;
    @Column(name = "document_number")
    String documentNumber;
    @Column(name = "address")
    String address;
}
