package br.pucrs.engswii.register.subject.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    Long id;
    String subjectCode;
    String subjectName;
    String subjectSchedule;
    Long subjectClass;
}
