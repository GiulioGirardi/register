package br.pucrs.engswii.register.matriculate.controller;


import br.pucrs.engswii.register.matriculate.dto.MatriculateDTO;
import br.pucrs.engswii.register.matriculate.entity.MatriculateEntity;
import br.pucrs.engswii.register.matriculate.service.MatriculateService;
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
@RequestMapping("matriculate-register/v1")
public class MatriculateController {

    private MatriculateService matriculateService;

    @Autowired
    public MatriculateController(MatriculateService matriculateService){
        this.matriculateService = matriculateService;
    }

    @PostMapping("/matriculate/register")
    public ResponseEntity<MatriculateEntity> registerMatriculates(@RequestBody MatriculateDTO matriculateDTO){
        MatriculateEntity matriculateEntity = new MatriculateEntity();
        BeanUtils.copyProperties(matriculateDTO, matriculateEntity);

        Optional<MatriculateEntity> optionalMatriculateEntity = matriculateService.saveMatriculates(matriculateEntity);

        if(optionalMatriculateEntity.isPresent()){
            return new ResponseEntity<>(optionalMatriculateEntity.get(),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
