package com.processamentoarquivoapi.domain.service;

import com.processamentoarquivoapi.api.dto.InfoDTO;
import com.processamentoarquivoapi.api.dto.filters.HomeFilter;
import com.processamentoarquivoapi.domain.repository.AgenteRepository;
import com.processamentoarquivoapi.domain.repository.ProcessamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final ProcessamentoRepository processamentoRepository;
    private final AgenteRepository agenteRepository;

    @Autowired
    public HomeService(ProcessamentoRepository processamentoRepository, AgenteRepository agenteRepository) {
        this.processamentoRepository = processamentoRepository;
        this.agenteRepository = agenteRepository;
    }

    public InfoDTO info(HomeFilter filter) {
        Long numOfProcess = processamentoRepository.getNumOfProcess(filter.getDataInicial(), filter.getDataFinal());
        Long numOfAgents = agenteRepository.getNumOfAgentes(filter.getDataInicial(), filter.getDataFinal());
        return new InfoDTO(numOfProcess, numOfAgents);
    }



}
