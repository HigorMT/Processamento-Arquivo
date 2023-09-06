package com.processamentoarquivoapi.core.converters;

import com.processamentoarquivoapi.api.dto.AgenteDTO;
import com.processamentoarquivoapi.core.utils.DateUtil;
import com.processamentoarquivoapi.domain.entity.Agente;
import com.processamentoarquivoapi.domain.entity.xml.AgenteXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AgenteConverter {

    private final AgenteDetalhesConverter detalhesConverter;

    @Autowired
    public AgenteConverter(AgenteDetalhesConverter detalhesConverter) {
        this.detalhesConverter = detalhesConverter;
    }


    public Agente toEntity(AgenteXml xml) {
        Agente agente = new Agente();
        agente.setCodigo(xml.getCodigo());

        try {
            SimpleDateFormat dateField = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataStr = xml.getData().substring(0, 19).replace("T", " ");
            Date date = dateField.parse(dataStr);
            LocalDateTime dateTime = DateUtil.toLocalDateTime(date);
            agente.setData(dateTime);
        } catch (Exception ignored) {
            System.out.println("Erro ao converter a Data do Agente: " + agente.getCodigo());
            System.out.println("Valor inserido: " + xml.getData());
        }

        agente.setDetalhes(detalhesConverter.toEntity(xml.getRegiao()));
        agente.getDetalhes().parallelStream().forEach(it -> it.setAgente(agente));
        return agente;
    }

    public List<Agente> toEntity(List<AgenteXml> xmls) {
        List<Agente> entities = new ArrayList<>();
        xmls.parallelStream().forEach(xml ->  entities.add(toEntity(xml)));
        return entities;
    }

    public AgenteDTO toDto(Agente entity) {
        AgenteDTO dto = new AgenteDTO();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setData(entity.getData());
        dto.setDetalhes(detalhesConverter.toDto(entity.getDetalhes()));
        return dto;
    }

    public List<AgenteDTO> toDto(List<Agente> entities) {
        if (entities.size() > 0) {
            List<AgenteDTO> dtos = new ArrayList<>();
            entities.forEach(entity -> dtos.add(toDto(entity)));
            return dtos;
        }
        return null;
    }


}
