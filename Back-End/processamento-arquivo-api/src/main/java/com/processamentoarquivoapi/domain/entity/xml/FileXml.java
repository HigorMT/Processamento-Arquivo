package com.processamentoarquivoapi.domain.entity.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "agentes")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileXml {

    @XmlElement(name = "agente")
    private List<AgenteXml> agentes;


}
