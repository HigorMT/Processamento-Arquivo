package com.processamentoarquivoapi.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoDTO {

    private Long arquivosProcessados;
    private Long agentesProcessados;

    public InfoDTO(Long arquivosProcessados, Long agentesProcessados) {
        this.arquivosProcessados = arquivosProcessados;
        this.agentesProcessados = agentesProcessados;
    }

}
