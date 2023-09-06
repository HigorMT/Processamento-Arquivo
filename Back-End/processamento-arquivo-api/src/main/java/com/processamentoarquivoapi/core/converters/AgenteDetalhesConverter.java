package com.processamentoarquivoapi.core.converters;

import com.processamentoarquivoapi.api.dto.AgenteDetalheDTO;
import com.processamentoarquivoapi.domain.entity.AgenteDetalhe;
import com.processamentoarquivoapi.domain.entity.xml.RegiaoXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AgenteDetalhesConverter {

    private final AgenteDetCompraConverter agenteDetCompraConverter;
    private final AgenteDetGeracaoConverter agenteDetGeracaoConverter;

    @Autowired
    public AgenteDetalhesConverter(AgenteDetCompraConverter agenteDetCompraConverter,
                                   AgenteDetGeracaoConverter agenteDetGeracaoConverter) {
        this.agenteDetCompraConverter = agenteDetCompraConverter;
        this.agenteDetGeracaoConverter = agenteDetGeracaoConverter;
    }

    public AgenteDetalhe toEntity(RegiaoXml xml) {
        if (Objects.nonNull(xml)) {
            AgenteDetalhe detalhe = new AgenteDetalhe();
            detalhe.setRegiao(xml.getSigla());
            detalhe.setDetalhesCompra(agenteDetCompraConverter.toEntity((xml.getCompra())));
            detalhe.setDetalhesGeracao(agenteDetGeracaoConverter.toEntity(xml.getGeracao()));

            detalhe.getDetalhesGeracao().parallelStream().forEach(it -> it.setAgenteDetalhe(detalhe));
            detalhe.getDetalhesCompra().parallelStream().forEach(it -> it.setAgenteDetalhe(detalhe));

            return detalhe;
        }
        return null;
    }

    public List<AgenteDetalhe> toEntity(List<RegiaoXml> xmls) {
        List<AgenteDetalhe> entities = new ArrayList<>();
        xmls.parallelStream().forEach(xml -> entities.add(toEntity(xml)));
        return entities;
    }

    public List<AgenteDetalheDTO> toDto(List<AgenteDetalhe> entities) {
        if (entities.size() > 0) {
            List<AgenteDetalheDTO> dtos = new ArrayList<>();
            entities.forEach(entity -> dtos.add(toDto(entity)));
            return dtos;
        }
        return null;
    }

    private AgenteDetalheDTO toDto(AgenteDetalhe entity) {
        if (Objects.nonNull(entity)) {
            AgenteDetalheDTO dto = new AgenteDetalheDTO();
            dto.setId(entity.getId());
            dto.setRegiao(entity.getRegiao());
            dto.setDetalhesCompra(agenteDetCompraConverter.toDto(entity.getDetalhesCompra()));
            dto.setDetalhesGeracao(agenteDetGeracaoConverter.toDto(entity.getDetalhesGeracao()));
            return dto;
        }
        return null;
    }

}
