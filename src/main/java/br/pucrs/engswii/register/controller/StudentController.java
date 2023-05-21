package br.pucrs.engswii.register.controller;

import br.pucrs.engswii.register.dto.StudentDTO;
import br.pucrs.engswii.register.entity.StudentEntity;
import br.pucrs.engswii.register.service.StudentService;
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
@RequestMapping("student-register/v1")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/register/student")
    public ResponseEntity<StudentEntity> registerStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentDTO, studentEntity);

        Optional<StudentEntity> optionalStudentEntity = studentService.saveStudent(studentEntity);

        if (optionalStudentEntity.isPresent()) {
            return new ResponseEntity<>(optionalStudentEntity.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
