package com.processamentoarquivoapi.api.dto.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.processamentoarquivoapi.domain.exception.ErrorDictionary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErroModel {

    private Integer code;
    private String message;
    private List<String> details;

    public void addDetails(final List<String> details) {
        this.details = details;
    }

    public ErroModel(ErrorDictionary error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public void addDetail(final String detail) {
        if(details == null)
            this.details = new ArrayList<>();

        details.add(detail);
    }
}
