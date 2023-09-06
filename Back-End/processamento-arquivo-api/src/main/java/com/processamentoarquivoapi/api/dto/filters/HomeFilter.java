package com.processamentoarquivoapi.api.dto.filters;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeFilter {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFinal;

}
