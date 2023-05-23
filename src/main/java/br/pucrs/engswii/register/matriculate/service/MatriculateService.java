package br.pucrs.engswii.register.matriculate.service;

import br.pucrs.engswii.register.matriculate.entity.MatriculateEntity;
import br.pucrs.engswii.register.matriculate.repository.MatriculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculateService {

    private MatriculateRepository matriculateRepository;

    @Autowired
    public MatriculateService(MatriculateRepository matriculateRepository){
        this.matriculateRepository = matriculateRepository;
    }

    public Optional<MatriculateEntity> saveMatriculates(MatriculateEntity matriculateEntity){
        return Optional.ofNullable(matriculateRepository.save(matriculateEntity));
    }

    public List<MatriculateEntity> findByRegistrationStudent(Long registrationStudent){
        return matriculateRepository.findMatriculateEntitiesByRegistrationStudent(registrationStudent);
    }

//    public

}
