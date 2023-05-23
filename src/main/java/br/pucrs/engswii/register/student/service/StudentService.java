package br.pucrs.engswii.register.student.service;

import br.pucrs.engswii.register.student.entity.StudentEntity;
import br.pucrs.engswii.register.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<StudentEntity> saveStudent(StudentEntity studentEntity) {
        return Optional.ofNullable(studentRepository.save(studentEntity));
    }

    public Optional<StudentEntity> findByRegistrationNumber(Long registrationNumber) {
        return studentRepository.findById(registrationNumber);
    }

    public List<StudentEntity> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentEntity> findByName(String name) {
        return studentRepository.findStudentEntitiesByNameContaining(name);
    }
}
