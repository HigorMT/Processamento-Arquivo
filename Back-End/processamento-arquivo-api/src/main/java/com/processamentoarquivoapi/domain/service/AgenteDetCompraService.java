package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.domain.repository.AgenteDetCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteDetCompraService {

    private final AgenteDetCompraRepository repository;

    @Autowired
    public AgenteDetCompraService(AgenteDetCompraRepository repository) {
        this.repository = repository;
    }

}
