package br.pucrs.engswii.register.user.controller;

import br.pucrs.engswii.register.user.dto.UserDTO;
import br.pucrs.engswii.register.user.entity.UserEntity;
import br.pucrs.engswii.register.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user-register/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder().build();
        BeanUtils.copyProperties(userDTO, userEntity);

        Optional<UserEntity> optionalUserEntity = userService.saveUser(userEntity);

        if (optionalUserEntity.isPresent()) {
            return new ResponseEntity<>(optionalUserEntity.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
