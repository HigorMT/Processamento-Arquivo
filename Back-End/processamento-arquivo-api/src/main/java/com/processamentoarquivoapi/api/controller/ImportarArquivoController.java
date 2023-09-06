package com.processamentoarquivoapi.api.controller;

import com.processamentoarquivoapi.api.dto.ProcessamentoDTO;
import com.processamentoarquivoapi.domain.service.ProcessamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/importar")
public class ImportarArquivoController {

    private final ProcessamentoService service;

    @Autowired
    public ImportarArquivoController(ProcessamentoService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProcessamentoDTO> importar(@RequestParam MultipartFile file) {
        return ResponseEntity.ok(service.processar(file));
    }

}
