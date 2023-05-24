package br.pucrs.engswii.register.user.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;
    String name;
    String email;
    String password;
}
