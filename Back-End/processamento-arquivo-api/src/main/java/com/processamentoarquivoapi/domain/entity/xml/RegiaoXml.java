package com.processamentoarquivoapi.domain.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class RegiaoXml {

    @XmlAttribute(name = "sigla")
    private String sigla;

    @XmlElement(name = "geracao")
    private GeracaoXml geracao;

    @XmlElement(name = "compra")
    private CompraXml compra;

    @XmlElement(name = "precoMedio")
    private PrecoMedioXml precoMedio;

}
