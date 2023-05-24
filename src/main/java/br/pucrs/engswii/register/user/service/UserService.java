package br.pucrs.engswii.register.user.service;


import br.pucrs.engswii.register.user.entity.UserEntity;
import br.pucrs.engswii.register.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> saveUser(UserEntity user) {
        return Optional.ofNullable(userRepository.save(user));
    }
}
