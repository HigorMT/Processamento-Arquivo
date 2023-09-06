package com.processamentoarquivoapi.domain.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class AgenteXml {

    @XmlElement(name = "codigo")
    private Long codigo;

    @XmlElement(name = "data")
    private String data;

    @XmlElement(name = "regiao")
    private List<RegiaoXml> regiao;

}
