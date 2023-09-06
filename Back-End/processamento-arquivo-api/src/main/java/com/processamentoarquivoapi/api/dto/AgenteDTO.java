package com.processamentoarquivoapi.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenteDTO {

    private Long id;

    private Long codigo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data;

    private List<AgenteDetalheDTO> detalhes;

    public AgenteDTO(Long id, Long codigo, LocalDateTime data) {
        this.id = id;
        this.codigo = codigo;
        this.data = data;
    }

}
