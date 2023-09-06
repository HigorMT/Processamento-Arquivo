package com.processamentoarquivoapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDictionary {

    INVALID_REQUEST_PARAMETERS(400, "Parâmetros de Requisição Inválidos."),
    INTERNAL_ERROR(500, "Erro Interno."),
    PROCESSING_ERROR(501, "Erro ao Processar Arquivo.");

    private final Integer code;
    private final String message;

}
