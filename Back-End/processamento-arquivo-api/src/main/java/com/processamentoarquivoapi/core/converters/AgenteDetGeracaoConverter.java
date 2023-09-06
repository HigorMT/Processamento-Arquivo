package com.processamentoarquivoapi.core.converters;

import com.processamentoarquivoapi.api.dto.AgenteDetGeracaoDTO;
import com.processamentoarquivoapi.api.dto.AgenteDetalheDTO;
import com.processamentoarquivoapi.domain.entity.AgenteDetGeracao;
import com.processamentoarquivoapi.domain.entity.AgenteDetalhe;
import com.processamentoarquivoapi.domain.entity.xml.GeracaoXml;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AgenteDetGeracaoConverter {

    public List<AgenteDetGeracao> toEntity(GeracaoXml xml) {
        List<AgenteDetGeracao> entities = new ArrayList<>();
//        xml.getValor().parallelStream().forEach(valor ->  entities.add(new AgenteDetGeracao(valor)));
        entities.add(new AgenteDetGeracao(xml.getValor().get(0)));
        return entities;
    }

    public List<AgenteDetGeracaoDTO> toDto(List<AgenteDetGeracao> entities) {
        if (entities.size() > 0) {
            List<AgenteDetGeracaoDTO> dtos = new ArrayList<>();
            entities.forEach(entity -> dtos.add(toDto(entity)));
            return dtos;
        }
        return null;
    }

    private AgenteDetGeracaoDTO toDto(AgenteDetGeracao entity) {
        if (Objects.nonNull(entity)) {
            AgenteDetGeracaoDTO dto = new AgenteDetGeracaoDTO();
            dto.setId(entity.getId());
            dto.setValor(entity.getValor());
            return dto;
        }
        return null;
    }

}
