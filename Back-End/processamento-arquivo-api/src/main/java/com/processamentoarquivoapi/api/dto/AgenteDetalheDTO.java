package com.processamentoarquivoapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenteDetalheDTO {

    private Long id;

    private String regiao;

    private List<AgenteDetCompraDTO> detalhesCompra;

    private List<AgenteDetGeracaoDTO> detalhesGeracao;

}
