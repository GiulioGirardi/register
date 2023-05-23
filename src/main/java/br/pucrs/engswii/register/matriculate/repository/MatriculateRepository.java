package br.pucrs.engswii.register.matriculate.repository;

import br.pucrs.engswii.register.matriculate.entity.MatriculateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculateRepository extends JpaRepository<MatriculateEntity, Long> {
    List<MatriculateEntity> findMatriculateEntitiesByRegistrationStudent(Long registrationStudent);
    List<MatriculateEntity> findMatriculateEntitiesBySubjectCode(String subjectCode);
    List<MatriculateEntity> findMatriculateEntitiesBySubjectClass(Long subjectClass);
}
