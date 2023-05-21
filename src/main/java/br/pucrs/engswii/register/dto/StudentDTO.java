package br.pucrs.engswii.register.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long registrationNumber;
    String name;
    String documentNumber;
    String address;
}
