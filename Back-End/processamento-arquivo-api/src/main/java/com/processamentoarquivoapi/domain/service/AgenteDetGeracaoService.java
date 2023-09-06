package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.domain.repository.AgenteDetGeracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteDetGeracaoService {

    private final AgenteDetGeracaoRepository repository;

    @Autowired
    public AgenteDetGeracaoService(AgenteDetGeracaoRepository repository) {
        this.repository = repository;
    }

}
