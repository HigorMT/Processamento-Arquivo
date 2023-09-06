package com.processamentoarquivoapi.api.controller;

import com.processamentoarquivoapi.api.dto.ProcessamentoDTO;
import com.processamentoarquivoapi.domain.service.ProcessamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/processamento")
public class ProcessamentoController {

    private final ProcessamentoService service;

    @Autowired
    public ProcessamentoController(ProcessamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProcessamentoDTO>> getAll() {
        return  ResponseEntity.ok(service.findAll());
    }

}
