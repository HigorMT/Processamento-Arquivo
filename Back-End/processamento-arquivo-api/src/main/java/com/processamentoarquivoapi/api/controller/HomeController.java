package com.processamentoarquivoapi.api.controller;

import com.processamentoarquivoapi.api.dto.InfoDTO;
import com.processamentoarquivoapi.api.dto.filters.HomeFilter;
import com.processamentoarquivoapi.domain.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService service;

    @Autowired
    public HomeController(HomeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<InfoDTO> getInfo(HomeFilter filter) {
        return ResponseEntity.ok(service.info(filter));
    }

}
