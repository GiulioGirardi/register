package br.pucrs.engswii.register.repository;

import br.pucrs.engswii.register.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findAll();
    List<StudentEntity> findStudentEntitiesByNameContaining(String name);
}
