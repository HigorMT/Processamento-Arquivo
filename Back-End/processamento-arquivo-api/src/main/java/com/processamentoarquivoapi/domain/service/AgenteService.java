package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.domain.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {

    private final AgenteRepository repository;

    @Autowired
    public AgenteService(AgenteRepository repository) {
        this.repository = repository;
    }


}
