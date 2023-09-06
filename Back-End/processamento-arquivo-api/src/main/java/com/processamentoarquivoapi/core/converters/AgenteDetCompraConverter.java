package com.processamentoarquivoapi.core.converters;

import com.processamentoarquivoapi.api.dto.AgenteDetCompraDTO;
import com.processamentoarquivoapi.api.dto.AgenteDetGeracaoDTO;
import com.processamentoarquivoapi.domain.entity.AgenteDetCompra;
import com.processamentoarquivoapi.domain.entity.AgenteDetGeracao;
import com.processamentoarquivoapi.domain.entity.xml.CompraXml;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AgenteDetCompraConverter {

    public List<AgenteDetCompra> toEntity(CompraXml xml) {
        List<AgenteDetCompra> entities = new ArrayList<>();
//        xml.getValor().parallelStream().forEach(valor ->  entities.add(new AgenteDetCompra(valor)));
        entities.add(new AgenteDetCompra(xml.getValor().get(0)));
        return entities;
    }

    public List<AgenteDetCompraDTO> toDto(List<AgenteDetCompra> entities) {
        if (entities.size() > 0) {
            List<AgenteDetCompraDTO> dtos = new ArrayList<>();
            entities.forEach(entity -> dtos.add(toDto(entity)));
            return dtos;
        }
        return null;
    }

    private AgenteDetCompraDTO toDto(AgenteDetCompra entity) {
        if (Objects.nonNull(entity)) {
            AgenteDetCompraDTO dto = new AgenteDetCompraDTO();
            dto.setId(entity.getId());
            dto.setValor(entity.getValor());
            return dto;
        }
        return null;
    }

}
