package br.pucrs.engswii.register.matriculate.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculateDTO {
    Long id;
    Long registrationStudent;
    String subjectCode;
    Long subjectClass;
}
