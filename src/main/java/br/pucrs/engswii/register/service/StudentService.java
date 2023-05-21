package br.pucrs.engswii.register.service;

import br.pucrs.engswii.register.entity.StudentEntity;
import br.pucrs.engswii.register.repository.StudentRepository;
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
}