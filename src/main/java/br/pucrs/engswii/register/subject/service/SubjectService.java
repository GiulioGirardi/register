package br.pucrs.engswii.register.subject.service;

import br.pucrs.engswii.register.subject.entity.SubjectEntity;
import br.pucrs.engswii.register.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Optional<SubjectEntity> saveSubject(SubjectEntity subjectEntity) {
        return Optional.ofNullable(subjectRepository.save(subjectEntity));
    }

}
