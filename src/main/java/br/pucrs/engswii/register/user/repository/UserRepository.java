package br.pucrs.engswii.register.user.repository;

import br.pucrs.engswii.register.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
