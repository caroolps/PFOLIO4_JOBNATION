package com.tecnocode.controller;

import com.tecnocode.converter.DtoToQualificationConverter;
import com.tecnocode.converter.QualificationToDtoConverter;
import com.tecnocode.model.Language;
import com.tecnocode.model.Qualification;
import com.tecnocode.payload.QualificationDTO;
import com.tecnocode.service.QualificationService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnocode.converter.DtoToQualificationConverter;
import com.tecnocode.converter.QualificationToDtoConverter;
import com.tecnocode.model.Qualification;
import com.tecnocode.payload.QualificationDTO;
import com.tecnocode.service.QualificationService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/qualification")
@RequiredArgsConstructor
public class QualificationController {
    private final QualificationService service;
    private final DtoToQualificationConverter dtoToQualificationConverter;
    private final QualificationToDtoConverter qualificationToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final QualificationDTO qualificationDTO) {
        try {
            Qualification qualification = service.save(dtoToQualificationConverter.convert(qualificationDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(qualificationToDtoConverter.convert(qualification));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{name}")
    public List<Qualification> buscarTodosComEstaQualificacao(@PathVariable("name") String name) {
        return service.buscarTodosComEstaQualificacao(name);
    }

    @GetMapping("/{level}")
    public List<Qualification> buscarTodosComEsteNivel(@PathVariable("level") String level) {
        return service.buscarTodosComEsteNivel(level);
    }

    @GetMapping("/{institution}")
    public List<Qualification> buscarTodosComEstaInstituicao(@PathVariable("institution") String institution) {
        return service.buscarTodosComEstaInstituicao(institution);
    }

    @GetMapping("/{start}")
    public List<Qualification> buscarTodosComEsteInicio(@PathVariable("start") LocalDate start) {
        return service.buscarTodosComEsteInicio(start);
    }

    @GetMapping("/{end}")
    public List<Qualification> buscarTodosComEsteFim(@PathVariable("end") LocalDate end) {
        return service.buscarTodosComEsteFim(end);
    }

    @GetMapping("/{status}")
    public List<Qualification> buscarTodosComEsteStatus(@PathVariable("status") String status) {
        return service.buscarTodosComEsteStatus(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/all")
    public List<Qualification> buscarTodos(){
        return service.buscarTodos();
    }

}
