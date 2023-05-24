package br.pucrs.engswii.register.matriculate.controller;

import br.pucrs.engswii.register.matriculate.dto.MatriculateDTO;
import br.pucrs.engswii.register.matriculate.entity.MatriculateEntity;
import br.pucrs.engswii.register.matriculate.exception.StudentAlreadyMatriculateException;
import br.pucrs.engswii.register.matriculate.service.MatriculateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("matriculate-register/v1")
public class MatriculateController {

    private MatriculateService matriculateService;

    @Autowired
    public MatriculateController(MatriculateService matriculateService) {
        this.matriculateService = matriculateService;
    }

    @PostMapping("/matriculate/register")
    public ResponseEntity<MatriculateEntity> registerMatriculates(@RequestBody MatriculateDTO matriculateDTO) throws StudentAlreadyMatriculateException {
        MatriculateEntity matriculateEntity = MatriculateEntity.builder().build();
        BeanUtils.copyProperties(matriculateDTO, matriculateEntity);

        if (matriculateService.studentAlreadyMatriculates(matriculateEntity)) {
            throw new StudentAlreadyMatriculateException();
        }

        Optional<MatriculateEntity> optionalMatriculateEntity = matriculateService.saveMatriculates(matriculateEntity);

        if (optionalMatriculateEntity.isPresent()) {
            return new ResponseEntity<>(optionalMatriculateEntity.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/matriculate/search-subject-student/{registration_number}")
    public ResponseEntity<List<MatriculateEntity>> getSubjectMatriculatesByStudent(@PathVariable(value = "registration_number") Long registrationNumber) {
        List<MatriculateEntity> listMatriculatesEntities = matriculateService.findByRegistrationStudent(registrationNumber);

        if (!listMatriculatesEntities.isEmpty()) {
            return new ResponseEntity<>(listMatriculatesEntities, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/matriculate/search-subject-code/{subject_code}")
    public ResponseEntity<List<MatriculateEntity>> getSubjectMatriculatesBySubjectCode(@PathVariable(value = "subject_code") String subjectCode) {
        List<MatriculateEntity> listMatriculatesEntities = matriculateService.findBySubjectCode(subjectCode);

        if (!listMatriculatesEntities.isEmpty()) {
            return new ResponseEntity<>(listMatriculatesEntities, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/matriculate/search-subject-class/{subject_class}")
    public ResponseEntity<List<MatriculateEntity>> getSubjectMatriculatesBySubjectClass(@PathVariable(value = "subject_class") Long subjectClass) {
        List<MatriculateEntity> listMatriculatesEntities = matriculateService.findBySubjectClass(subjectClass);

        if (!listMatriculatesEntities.isEmpty()) {
            return new ResponseEntity<>(listMatriculatesEntities, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
