package com.processamentoarquivoapi.core.converters;

import com.processamentoarquivoapi.api.dto.AgenteDTO;
import com.processamentoarquivoapi.api.dto.AgenteDetalheDTO;
import com.processamentoarquivoapi.api.dto.ProcessamentoDTO;
import com.processamentoarquivoapi.domain.entity.Agente;
import com.processamentoarquivoapi.domain.entity.Processamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ProcessamentoConverter {

    private final AgenteConverter agenteConverter;

    @Autowired
    public ProcessamentoConverter(AgenteConverter agenteConverter) {
        this.agenteConverter = agenteConverter;
    }

    public ProcessamentoDTO toDto(Processamento entity) {
        ProcessamentoDTO dto = new ProcessamentoDTO();
        dto.setId(entity.getId());
        dto.setDataProcessamento(entity.getDataProcessamento());
        dto.setNomeArquivo(entity.getNomeArquivo());
        dto.setAgentes( agenteConverter.toDto(entity.getAgentes()));

        if (dto.getAgentes().size() > 1) {
            dto.getAgentes().sort(Comparator.comparing(AgenteDTO::getCodigo));
        }

        return dto;
    }

    public List<ProcessamentoDTO> toDto(List<Processamento> entities) {
        List<ProcessamentoDTO> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            entities.forEach(entity -> dtos.add(toDto(entity)));
        }
        return dtos;
    }

}
