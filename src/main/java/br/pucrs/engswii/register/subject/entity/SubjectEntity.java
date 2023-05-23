package br.pucrs.engswii.register.subject.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "subject_code")
    String subjectCode;
    @Column(name = "subject_name")
    String subjectName;
    @Column(name = "subject_schedule")
    String subjectSchedule;
    @Column(name = "subject_class")
    Long subjectClass;
}
