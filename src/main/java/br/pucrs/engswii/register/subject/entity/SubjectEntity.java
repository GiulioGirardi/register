package br.pucrs.engswii.register.subject.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "subject_code", nullable = false)
    String subjectCode;

    @Column(name = "subject_name", nullable = false)
    String subjectName;

    @Column(name = "subject_schedule", nullable = false)
    String subjectSchedule;

    @Column(name = "subject_class", nullable = false)
    Long subjectClass;
}
