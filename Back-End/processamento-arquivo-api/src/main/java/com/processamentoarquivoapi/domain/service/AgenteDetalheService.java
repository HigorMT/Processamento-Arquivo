package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.domain.repository.AgenteDetalheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteDetalheService {

    private final AgenteDetalheRepository repository;

    @Autowired
    public AgenteDetalheService(AgenteDetalheRepository repository) {
        this.repository = repository;
    }

}
